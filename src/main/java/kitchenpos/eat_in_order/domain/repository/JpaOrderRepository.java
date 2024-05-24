package kitchenpos.eat_in_order.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

import kitchenpos.eat_in_order.domain.Order;

public interface JpaOrderRepository extends OrderRepository, JpaRepository<Order, UUID> {
}
