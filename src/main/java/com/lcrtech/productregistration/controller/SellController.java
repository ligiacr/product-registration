package com.lcrtech.productregistration.controller;

import com.lcrtech.productregistration.dto.SellDTO;
import com.lcrtech.productregistration.model.Item;
import com.lcrtech.productregistration.model.Product;
import com.lcrtech.productregistration.model.Sell;
import com.lcrtech.productregistration.service.SellService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/sell")
public class SellController {

    @Autowired
    private SellService sellService;

    @GetMapping
    public ModelAndView listSell(RedirectAttributes ra) {
        ModelAndView mav = new ModelAndView("sell/sell");
        mav.addObject("sales", sellService.listSell());
        mav.addObject(new Sell());

        return mav;
    }

    @GetMapping("/new")
    public ModelAndView newSell() {
        ModelAndView mav = new ModelAndView("sell/new");
        return mav;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> newSell(@RequestBody SellDTO dto) {
        System.out.println(dto);
        return ResponseEntity.ok().body("Venda realizada com sucesso!");
    }
}
