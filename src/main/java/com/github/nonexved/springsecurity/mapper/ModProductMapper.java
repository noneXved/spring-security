package com.github.nonexved.springsecurity.mapper;

import com.github.nonexved.springsecurity.dto.ModProductDto;

import com.github.nonexved.springsecurity.model.Product;
import org.mapstruct.Mapper;

import java.util.Set;


@Mapper(componentModel = "spring")
public interface ModProductMapper {

    ModProductDto map(Product product);
	
	Product map(ModProductDto modProductDto);

    Set<ModProductDto> map(Set<Product> products);
}
