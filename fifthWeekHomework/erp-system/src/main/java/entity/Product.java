package main.java.entity;

import main.java.util.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "products")
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "product_id"
        )
)
public class Product extends BaseEntity {
    private String name;
    private double price;
    private boolean includesVAT;
    private boolean inStock;
}
