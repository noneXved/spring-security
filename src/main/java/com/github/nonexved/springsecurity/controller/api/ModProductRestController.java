package com.github.nonexved.springsecurity.controller.api;

import com.github.nonexved.springsecurity.dto.ModProductDto;
import com.github.nonexved.springsecurity.mapper.ModProductMapper;
import com.github.nonexved.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/secured/mod/product")
@RequiredArgsConstructor
public class ModProductRestController {

    private final ProductService productService;

    private final ModProductMapper productMapper;

    @GetMapping
    @PreAuthorize("hasRole('MOD') and hasRole('USER')")
    public Set<ModProductDto> findAll() {
        return productMapper.map(productService.findAll());
    }

    @PostMapping
    @PreAuthorize("hasRole('MOD') and hasRole('USER')")
    public ResponseEntity<?> create(@RequestBody ModProductDto modProductDto) {
        productService.create(productMapper.map(modProductDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
