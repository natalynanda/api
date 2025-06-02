package com.market.api.persistence.mapper;

import com.market.api.domain.Purchase;
import com.market.api.persistence.entity.Sale;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "saleId", target = "purchaseId"),
            @Mapping(source = "payMethod", target = "paymentMethod"),
            @Mapping(source = "comments", target = "comment"),
            @Mapping(source = "products", target = "items"),
    })
    Purchase toPurchase(Sale sale);
    List<Purchase> toPurchases(List<Sale> sales);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Sale toSale(Purchase purchase);
}
