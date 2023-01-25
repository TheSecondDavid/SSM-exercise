package com.zhouhao.controller;

import com.zhouhao.entity.Product;
import com.zhouhao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Secured("ROLE_ADMIN")
    @RequestMapping("/list")
    public String getlist(Model model){
        model.addAttribute("products", productService.getlist());
        return "product-list";
    }

    @RequestMapping("/add")
    public String add(Model model, Product product){
        productService.save(product);
        model.addAttribute("products", productService.getlist());
        return "product-list";
    }
}
