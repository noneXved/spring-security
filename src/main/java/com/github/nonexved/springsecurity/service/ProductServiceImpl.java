package com.github.nonexved.springsecurity.service;


import com.github.nonexved.springsecurity.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductService {

    private static Set<Product> PRODUCTS = Stream.of(
            new Product(1l, "TV", "eXFgWZ76qTkwxZ3nUer1", 3100, 100),
            new Product(2l, "Mouse", "CqLwuYAcjHXRbhIGB3j2", 5.45, 10),
            new Product(3l, "Keyboard", "sZXtStekttJ6CfsXz0xe", 22.45, 600)
    ).collect(Collectors.toCollection(HashSet::new));

    @Override
    public Set<Product> findAll() {
        return PRODUCTS;
    }

    @Override
    public Product find(long id) {
        return PRODUCTS.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void create(Product product) {
        Product max = Collections.max(PRODUCTS, Comparator.comparing(Product::getId));
        long maxId = 0;
        if (max != null) {
            maxId = max.getId() + 1;
        }
        product.setId(maxId);
        
        PRODUCTS.add(product);
    }

    @Override
    public void delete(Long id) {
        PRODUCTS.removeIf(product -> id == product.getId());
    }

    @Override
    public void delete(Product product) {
        PRODUCTS.remove(product);
    }
}
