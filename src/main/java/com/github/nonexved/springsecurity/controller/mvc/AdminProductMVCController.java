package com.github.nonexved.springsecurity.controller.mvc;

import com.github.nonexved.springsecurity.mapper.AdminProductMapper;
import com.github.nonexved.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secured/admin/product")
@RequiredArgsConstructor
public class AdminProductMVCController {

    private final ProductService productService;

    private final AdminProductMapper productMapper;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productMapper.map(productService.findAll()));

        return "admin-list";
    }
}
