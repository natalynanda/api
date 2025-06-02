package com.market.api.persistence.mapper;

import com.market.api.domain.PurchaseItem;
import com.market.api.persistence.entity.SaleProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "state", target = "active")
    })
    PurchaseItem toPurchaseItem(SaleProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "sale", ignore = true),
            @Mapping(target = "id.saleId", ignore = true)
    })
    SaleProduct toSaleProduct(PurchaseItem item);
}
