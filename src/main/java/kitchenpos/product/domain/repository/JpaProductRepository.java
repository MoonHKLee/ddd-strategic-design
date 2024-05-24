package kitchenpos.product.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

import kitchenpos.product.domain.Product;

public interface JpaProductRepository extends ProductRepository, JpaRepository<Product, UUID> {
}
