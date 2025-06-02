package com.market.api.persistence.mapper;

import com.market.api.domain.CategoryDto;
import com.market.api.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "categoryId", target ="categoryId"),
            @Mapping(source = "description", target ="category"),
            @Mapping(source = "active", target ="active"),
    })
    CategoryDto toCategoryDto(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDto categoryDto);
}
