package com.github.nonexved.springsecurity.mapper;

import com.github.nonexved.springsecurity.dto.ProductDto;
import com.github.nonexved.springsecurity.model.Product;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto map(Product product);

    Set<ProductDto> map(Set<Product> products);
}
