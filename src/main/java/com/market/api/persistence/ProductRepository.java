package com.market.api.persistence;

import com.market.api.domain.ProductDto;
import com.market.api.domain.repository.ProductDtoRepository;
import com.market.api.persistence.entity.Product;
import com.market.api.persistence.crud.ProductCrudRepository;
import com.market.api.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductDtoRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return productMapper.toProductsDto(products);
    }

    @Override
    public Optional<List<ProductDto>> getByCategoryId(Integer categoryId) {
        List<Product> products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(productMapper.toProductsDto(products));
    }

    @Override
    public Optional<List<ProductDto>> getLowStock(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndActive(quantity, true);
        return products.map(prods -> productMapper.toProductsDto(prods));
    }

    @Override
    public Optional<ProductDto> getProductById(Integer id) {
        return productCrudRepository.findById(id).map(product -> productMapper.toProductDto(product));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        return productMapper.toProductDto(product);
    }

    @Override
    public void delete(Integer id) {
        productCrudRepository.deleteById(id);
    }
}
