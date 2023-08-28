package main.java.repository;

import main.java.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select count(p) from Product p where p.name=:name")
    int findProductCountByName(@Param("name") String name);

    @Query(value = "select p from Product p where p.uuid=:uuid")
    Optional<Product> findProductByUuid(@Param("uuid") UUID uuid);
}
