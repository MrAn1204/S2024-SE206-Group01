package se206.group01.mobileworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se206.group01.mobileworld.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductType(String productType);
}