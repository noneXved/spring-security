package com.github.nonexved.springsecurity.controller.mvc;

import com.github.nonexved.springsecurity.mapper.ModProductMapper;
import com.github.nonexved.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secured/mod/product")
@RequiredArgsConstructor
public class ModProductMVCController {

    private final ProductService productService;

    private final ModProductMapper productMapper;

    @GetMapping
    @PreAuthorize("hasRole('MOD') and hasRole('USER')")
    public String list(Model model) {
        model.addAttribute("products", productMapper.map(productService.findAll()));

        return "mod-list";
    }


}
