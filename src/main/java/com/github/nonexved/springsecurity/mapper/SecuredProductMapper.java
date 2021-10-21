package com.github.nonexved.springsecurity.mapper;


import com.github.nonexved.springsecurity.dto.SecuredProductDto;
import com.github.nonexved.springsecurity.model.Product;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface SecuredProductMapper {

    SecuredProductDto map(Product product);

    Set<SecuredProductDto> map(Set<Product> products);
}
