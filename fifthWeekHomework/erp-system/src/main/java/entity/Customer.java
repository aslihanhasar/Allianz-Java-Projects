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
@Table(name = "customers")
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "customer_id"
        )
)
public class Customer extends BaseEntity {
    private String name;
    private String surname;
    private String email;
    @Builder.Default
    private Boolean active=true;

}
