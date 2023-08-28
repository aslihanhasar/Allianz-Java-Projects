package main.java.service;

import main.java.dto.customer.CustomerSaveRequest;
import main.java.dto.customer.CustomerSaveResponse;
import main.java.dto.customer.CustomerUpdateRequest;
import main.java.entity.Customer;
import main.java.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    /**
     * Saves a new customer record based on the provided `CustomerSaveRequest`.
     *
     * @param customerSaveRequest The request object containing customer data to be saved.
     * @return A response object containing the saved customer's information.
     * @throws RuntimeException if a customer with the same email already exists.
     */
    @Transactional
    public CustomerSaveResponse save(CustomerSaveRequest customerSaveRequest) {
        checkIsCustomerAlreadySaved(customerSaveRequest);
        Customer savedCustomer = buildCustomerAndSave(customerSaveRequest);
        return convertCustomerToResponse(savedCustomer);
    }

    /**
     * Retrieves a list of all customers currently stored in the system.
     *
     * @return A list of all customer records.
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Retrieves a reference to a customer by their ID without fully loading their data.
     *
     * @param id The ID of the customer to retrieve.
     * @return A reference to the customer.
     */
    public Customer getReferenceById(Long id) {
        return customerRepository.getReferenceById(id);
    }

    /**
     * Updates an existing customer's information based on the provided `CustomerUpdateRequest`.
     *
     * @param customerUpdateRequest The request object containing updated customer data.
     * @return A response object containing the updated customer's information.
     * @throws RuntimeException if the specified customer does not exist.
     */
    public CustomerSaveResponse update(CustomerUpdateRequest customerUpdateRequest) {
        Optional<Customer> customerOptional = customerRepository.findById(customerUpdateRequest.getId());
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setName(customerUpdateRequest.getName());
            customer.setSurname(customerUpdateRequest.getSurname());
            customer.setEmail(customerUpdateRequest.getEmail());
            Customer savedCustomer = customerRepository.save(customer);
            return convertCustomerToResponse(savedCustomer);
        }
        throw new RuntimeException("Customer not found");
    }

    /**
     * Logically deletes a customer by marking them as inactive and removing them from the database.
     *
     * @param uuid The UUID of the customer to delete.
     * @throws RuntimeException if the specified customer does not exist.
     */
    @Transactional
    public void delete(UUID uuid) {
        Customer customer = getCustomerByUUID(uuid);
        if (customer != null) {
            customer.setActive(false);
            customerRepository.save(customer);
            customerRepository.deleteById(customer.getId());
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    /**
     * Retrieves a customer by their UUID.
     *
     * @param uuid The UUID of the customer to retrieve.
     * @return The customer object if found, or null if not found.
     */
    public Customer getCustomerByUUID(UUID uuid) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByUuid(uuid);
        return customerOptional.orElse(null);
    }

    private Customer buildCustomerAndSave(CustomerSaveRequest customerSaveRequest) {
        Customer newCustomer = Customer
                .builder()
                .name(customerSaveRequest.getName())
                .surname(customerSaveRequest.getSurname())
                .email(customerSaveRequest.getEmail())
                .build();
        return customerRepository.save(newCustomer);
    }

    private CustomerSaveResponse convertCustomerToResponse(Customer customer) {
        return CustomerSaveResponse
                .builder()
                .id(customer.getId())
                .nameSurname(customer.getName() + " " + customer.getSurname())
                .email(customer.getEmail())
                .build();
    }

    private void checkIsCustomerAlreadySaved(CustomerSaveRequest customerSaveRequest) {
        int customerCountByEmail = customerRepository.findCustomerCountByEmail(customerSaveRequest.getEmail());
        if (customerCountByEmail > 0) {
            throw new RuntimeException("The customer is already exist");
        }
    }
}
