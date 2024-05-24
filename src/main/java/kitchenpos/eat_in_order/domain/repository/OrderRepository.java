package kitchenpos.eat_in_order.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import kitchenpos.eat_in_order.domain.Order;
import kitchenpos.eat_in_order.domain.OrderStatus;
import kitchenpos.eat_in_order.domain.OrderTable;

public interface OrderRepository {
    Order save(Order order);

    Optional<Order> findById(UUID id);

    List<Order> findAll();

    boolean existsByOrderTableAndStatusNot(OrderTable orderTable, OrderStatus status);
}

