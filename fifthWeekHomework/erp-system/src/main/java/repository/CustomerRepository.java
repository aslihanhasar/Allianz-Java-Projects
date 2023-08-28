package main.java.repository;

import main.java.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "select count(c) from Customer c where c.email=:email")
    int findCustomerCountByEmail(@Param("email") String email);

    @Query(value = "select c from Customer c where c.uuid=:uuid")
    Optional<Customer> findCustomerByUuid(@Param("uuid") UUID uuid);

}

