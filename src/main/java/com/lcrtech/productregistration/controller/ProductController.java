package com.lcrtech.productregistration.controller;

import com.lcrtech.productregistration.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {

    @Autowired
    private ProductRepository products;

    @GetMapping("/products")
    public ModelAndView listProducts() {
        ModelAndView mav = new ModelAndView("ProductList");
        mav.addObject("products",products.findAll());

        return mav;
    }
}
