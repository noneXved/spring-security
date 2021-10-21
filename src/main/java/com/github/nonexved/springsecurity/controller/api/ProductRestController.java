package com.github.nonexved.springsecurity.controller.api;

import com.github.nonexved.springsecurity.dto.ProductDto;
import com.github.nonexved.springsecurity.mapper.ProductMapper;
import com.github.nonexved.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    @GetMapping
    public Set<ProductDto> findAll() {
        return productMapper.map(productService.findAll());
    }
}
