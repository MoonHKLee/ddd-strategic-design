package kitchenpos.orders.eatin.application;

import kitchenpos.menus.domain.Menu;
import kitchenpos.menus.domain.MenuRepository;
import kitchenpos.common.domain.OrderType;
import kitchenpos.orders.eatin.domain.EatInOrder;
import kitchenpos.orders.eatin.domain.EatInOrderLineItem;
import kitchenpos.orders.eatin.domain.EatInOrderRepository;
import kitchenpos.orders.eatin.domain.EatInOrderStatus;
import kitchenpos.orders.eatin.domain.OrderTable;
import kitchenpos.orders.eatin.domain.OrderTableRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class EatInOrderService {
    private final EatInOrderRepository orderRepository;
    private final MenuRepository menuRepository;
    private final OrderTableRepository orderTableRepository;

    public EatInOrderService(
        final EatInOrderRepository orderRepository,
        final MenuRepository menuRepository,
        final OrderTableRepository orderTableRepository
    ) {
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
        this.orderTableRepository = orderTableRepository;
    }

    @Transactional
    public EatInOrder create(final EatInOrder request) {
        final OrderType type = request.getType();
        if (Objects.isNull(type) || type != OrderType.EAT_IN) {
            throw new IllegalArgumentException();
        }
        final List<EatInOrderLineItem> orderLineItemRequests = request.getEatInOrderLineItems();
        if (Objects.isNull(orderLineItemRequests) || orderLineItemRequests.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final List<Menu> menus = menuRepository.findAllByIdIn(
            orderLineItemRequests.stream()
                .map(EatInOrderLineItem::getMenuId)
                .toList()
        );
        if (menus.size() != orderLineItemRequests.size()) {
            throw new IllegalArgumentException();
        }
        final List<EatInOrderLineItem> orderLineItems = new ArrayList<>();
        for (final EatInOrderLineItem orderLineItemRequest : orderLineItemRequests) {
            final long quantity = orderLineItemRequest.getQuantity();
            final Menu menu = menuRepository.findById(orderLineItemRequest.getMenuId())
                .orElseThrow(NoSuchElementException::new);
            if (!menu.isDisplayed()) {
                throw new IllegalStateException();
            }
            if (menu.getPrice().compareTo(orderLineItemRequest.getPrice()) != 0) {
                throw new IllegalArgumentException();
            }
            final EatInOrderLineItem orderLineItem = new EatInOrderLineItem();
            orderLineItem.setMenu(menu);
            orderLineItem.setQuantity(quantity);
            orderLineItems.add(orderLineItem);
        }
        EatInOrder order = new EatInOrder();
        order.setId(UUID.randomUUID());
        order.setType(type);
        order.setStatus(EatInOrderStatus.WAITING);
        order.setOrderDateTime(LocalDateTime.now());
        order.setEatInOrderLineItems(orderLineItems);
        final OrderTable orderTable = orderTableRepository.findById(request.getOrderTableId())
            .orElseThrow(NoSuchElementException::new);
        if (!orderTable.isOccupied()) {
            throw new IllegalStateException();
        }
        order.setOrderTable(orderTable);
        return orderRepository.save(order);
    }

    @Transactional
    public EatInOrder accept(final UUID orderId) {
        final EatInOrder order = orderRepository.findById(orderId)
            .orElseThrow(NoSuchElementException::new);
        if (order.getStatus() != EatInOrderStatus.WAITING) {
            throw new IllegalStateException();
        }
        order.setStatus(EatInOrderStatus.ACCEPTED);
        return order;
    }

    @Transactional
    public EatInOrder serve(final UUID orderId) {
        final EatInOrder order = orderRepository.findById(orderId)
            .orElseThrow(NoSuchElementException::new);
        if (order.getStatus() != EatInOrderStatus.ACCEPTED) {
            throw new IllegalStateException();
        }
        order.setStatus(EatInOrderStatus.SERVED);
        return order;
    }

    @Transactional
    public EatInOrder complete(final UUID orderId) {
        final EatInOrder order = orderRepository.findById(orderId)
            .orElseThrow(NoSuchElementException::new);
        final EatInOrderStatus status = order.getStatus();
        if (status != EatInOrderStatus.SERVED) {
            throw new IllegalStateException();
        }
        order.setStatus(EatInOrderStatus.COMPLETED);
        final OrderTable orderTable = order.getOrderTable();
        if (!orderRepository.existsByOrderTableAndStatusNot(orderTable, EatInOrderStatus.COMPLETED)) {
            orderTable.setNumberOfGuests(0);
            orderTable.setOccupied(false);
        }
        return order;
    }

    @Transactional(readOnly = true)
    public List<EatInOrder> findAll() {
        return orderRepository.findAll();
    }
}
