package com.market.api.persistence;

import com.market.api.domain.Purchase;
import com.market.api.domain.repository.PurchaseRepository;
import com.market.api.persistence.crud.SaleCrudRepository;
import com.market.api.persistence.entity.Sale;
import com.market.api.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SaleRepository implements PurchaseRepository {
    @Autowired
    private SaleCrudRepository saleCrudRepository;

    @Autowired
    private PurchaseMapper mapper;


    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Sale>)saleCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return saleCrudRepository.findByClientId(clientId)
                .map(sales -> mapper.toPurchases(sales));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Sale sale = mapper.toSale(purchase);
        sale.getProducts().forEach(saleProduct -> saleProduct.setSale(sale));
        return mapper.toPurchase(saleCrudRepository.save(sale));
    }
}
