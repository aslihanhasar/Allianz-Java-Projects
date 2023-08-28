package main.java.controller;

import main.java.dto.BaseResponse;
import main.java.dto.customer.CustomerSaveRequest;
import main.java.dto.customer.CustomerSaveResponse;
import main.java.dto.customer.CustomerUpdateRequest;
import main.java.entity.Customer;
import main.java.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<BaseResponse<CustomerSaveResponse>> createCustomer
            (@RequestBody CustomerSaveRequest customerSaveRequest){
        CustomerSaveResponse customerSaveResponse= customerService.save(customerSaveRequest);
        var response=BaseResponse.<CustomerSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(customerSaveResponse)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<CustomerSaveResponse>> updateCustomer
            (@RequestBody CustomerUpdateRequest customerUpdateRequest){
         CustomerSaveResponse customerSaveResponse=customerService.update(customerUpdateRequest);
        var response=BaseResponse.<CustomerSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(customerSaveResponse)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{uuid}")
    public void deleteCustomer(@PathVariable("uuid") UUID uuid){
        customerService.delete(uuid);
    }
}
