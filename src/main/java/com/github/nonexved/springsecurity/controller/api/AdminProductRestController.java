package com.github.nonexved.springsecurity.controller.api;

import com.github.nonexved.springsecurity.dto.AdminProductDto;
import com.github.nonexved.springsecurity.mapper.AdminProductMapper;
import com.github.nonexved.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/secured/admin/product")
@RequiredArgsConstructor
public class AdminProductRestController {

    private final ProductService productService;

    private final AdminProductMapper productMapper;

    @GetMapping
    public Set<AdminProductDto> findAll() {
        return productMapper.map(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AdminProductDto adminProductDto) {
        productService.create(productMapper.map(adminProductDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
