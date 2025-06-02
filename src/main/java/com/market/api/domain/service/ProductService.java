package com.market.api.domain.service;

import com.market.api.domain.ProductDto;
import com.market.api.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public List<ProductDto> getAll() {
        return productRepository.getAll();
    }
    
    public Optional<ProductDto> getProduct(int productId) {
        return productRepository.getProductById(productId);
    }

    public Optional<List<ProductDto>> getByCategory(int categoryId) {
        return productRepository.getByCategoryId(categoryId);
    }

    public ProductDto save(ProductDto productDto) {
        return productRepository.save(productDto);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
