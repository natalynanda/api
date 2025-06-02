package com.market.api.persistence.crud;

import com.market.api.persistence.entity.Product;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
//    @Query(value = "SELECT p FROM Product p WHERE p.category_id = ?", nativeQuery = true)
    List<Product> findByCategoryIdOrderByNameAsc(Integer categoryId);
    Optional<List<Product>> findByStockQuantityLessThanAndActive(int stockQuantity, Boolean active);
}
