package com.market.api.domain.service;

import com.market.api.domain.ProductDto;
import com.market.api.domain.Purchase;
import com.market.api.persistence.ProductRepository;
import com.market.api.persistence.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private SaleRepository saleRepository;
    
    public List<Purchase> getAll() {
        return saleRepository.getAll();
    }

    public Optional<List<Purchase>> getByClientId(String clientId) {
        return saleRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase) {
        return saleRepository.save(purchase);
    }
}
