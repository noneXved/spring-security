package com.github.nonexved.springsecurity.controller.mvc;

import com.github.nonexved.springsecurity.mapper.ProductMapper;
import com.github.nonexved.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductMVCController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productMapper.map(productService.findAll()));

        return "list";
    }


}
