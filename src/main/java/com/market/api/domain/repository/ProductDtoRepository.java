package com.market.api.domain.repository;

import com.market.api.domain.ProductDto;
import com.market.api.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDtoRepository {
    List<ProductDto> getAll();
    Optional<List<ProductDto>> getByCategoryId(Integer categoryId);
    Optional<List<ProductDto>> getLowStock(int quantity);
    Optional<ProductDto> getProductById(Integer id);
    ProductDto save(ProductDto productDto);
    void delete(Integer id);
}
