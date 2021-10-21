package com.github.nonexved.springsecurity.mapper;


import com.github.nonexved.springsecurity.dto.AdminProductDto;
import com.github.nonexved.springsecurity.model.Product;
import org.mapstruct.Mapper;

import java.util.Set;


@Mapper(componentModel = "spring")
public interface AdminProductMapper {

    AdminProductDto map(Product product);

    Product map(AdminProductDto adminProductDto);

    Set<AdminProductDto> map(Set<Product> products);
}
