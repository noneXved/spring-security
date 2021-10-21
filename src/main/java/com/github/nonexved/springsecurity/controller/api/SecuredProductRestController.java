package com.github.nonexved.springsecurity.controller.api;

import com.github.nonexved.springsecurity.dto.SecuredProductDto;
import com.github.nonexved.springsecurity.mapper.SecuredProductMapper;
import com.github.nonexved.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/secured/product")
@RequiredArgsConstructor
public class SecuredProductRestController {

    private final ProductService productService;

    private final SecuredProductMapper productMapper;

    @GetMapping
    public Set<SecuredProductDto> findAll() {
        return productMapper.map(productService.findAll());
    }
}
