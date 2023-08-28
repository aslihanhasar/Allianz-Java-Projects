package main.java.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerUpdateRequest {
    private Long id;
    private String name;
    private String surname;
    private String email;
}
