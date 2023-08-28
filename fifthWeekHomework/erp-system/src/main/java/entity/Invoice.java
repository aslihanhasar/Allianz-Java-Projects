package main.java.entity;

import main.java.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "invoices")
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "invoice_number"
        )
)
public class Invoice extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<InvoiceItem> items;
    private LocalDate invoiceDate;
    private double totalAmountWithoutVAT;
    private double totalAmountWithVAT;
}
