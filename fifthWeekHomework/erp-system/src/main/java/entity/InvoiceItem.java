package main.java.entity;

import main.java.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "invoice_items")
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "invoice_item_id"
        )
)
public class InvoiceItem extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_number")
    private Invoice invoice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;
    private int quantity;
    private double unitPriceWithoutVAT;
    private double unitPriceWithVAT;
    private double totalAmountWithoutVAT;
    private double totalAmountWithVAT;
}
