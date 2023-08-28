package main.java.repository;

import main.java.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    @Query(value = "select o from OrderItem o where o.uuid=:uuid")
    Optional<OrderItem> findOrderItemByUuid(@Param("uuid") UUID uuid);
}
