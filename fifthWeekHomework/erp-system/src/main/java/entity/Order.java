package main.java.entity;

import main.java.enums.OrderStatus;
import main.java.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Data
@Entity
@Table(name = "orders")
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "order_id"
        )
)
public class Order extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;
}
