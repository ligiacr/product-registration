package com.lcrtech.productregistration.controller;

import com.lcrtech.productregistration.model.Product;
import com.lcrtech.productregistration.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView listProducts(RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView("ProductList");
        mav.addObject("products", productService.listProducts());
        mav.addObject(new Product());

        return mav;
    }

    @PostMapping
    public String save(Product product) {
        productService.saveProduct(product);

        return "redirect:/";
    }

   @GetMapping("/edit/{id}")
   public ModelAndView edit(@PathVariable("id") Long id, RedirectAttributes ra) {
        ModelAndView mav = new ModelAndView("ProductList");
        mav.addObject("product", productService.findProductById(id));
        mav.addObject("products", productService.listProducts());

        return mav;
   }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes ra) {

        productService.deleteProduct(id);

        ra.addFlashAttribute("success", "Produto excluído com sucesso.");

        return "redirect:/";
    }
}
