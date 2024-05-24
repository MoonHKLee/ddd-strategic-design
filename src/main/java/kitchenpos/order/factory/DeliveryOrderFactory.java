package kitchenpos.order.factory;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import kitchenpos.order.domain.DeliveryOrder;
import kitchenpos.order.domain.Order;
import kitchenpos.order.domain.OrderLineItems;
import kitchenpos.order.domain.OrderStatus;
import kitchenpos.order.domain.OrderTable;

@Component
public class DeliveryOrderFactory implements OrderFactory {

    @Override
    public Order createOrder(OrderLineItems orderLineItems, OrderTable orderTable, String deliveryAddress) {
        return new DeliveryOrder(
            OrderStatus.WAITING,
            LocalDateTime.now(),
            orderLineItems,
            deliveryAddress
        );
    }
}

