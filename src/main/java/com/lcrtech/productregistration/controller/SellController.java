package com.lcrtech.productregistration.controller;

import com.lcrtech.productregistration.dto.SellDTO;
import com.lcrtech.productregistration.exception.ItemsNotFoundException;
import com.lcrtech.productregistration.model.Item;
import com.lcrtech.productregistration.model.Sell;
import com.lcrtech.productregistration.service.ProductService;
import com.lcrtech.productregistration.service.SellService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sell")
public class SellController {

    @Autowired
    private SellService sellService;

    @Autowired
    private ProductService productService;

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
    public ResponseEntity<String> newSell(@RequestBody SellDTO dto) {
        dto.setDate(LocalDateTime.now());
        Sell sell = new Sell();
        Item item = new Item();
        List<Item> items = new ArrayList<>();
        convert(dto, sell, item, items);
        try {
            productService.updateQuantity(item);
            sellService.saveSell(sell);

            return ResponseEntity.ok().body("Venda realizada com sucesso!");

        } catch (ItemsNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.badRequest().body("Erro ao processar a venda! Quantidade indisponível em estoque.");
    }

    private void convert(SellDTO dto, Sell sell, Item item, List<Item> items) {
        dto.getItems().forEach(i -> {
            BeanUtils.copyProperties(i, item);
            items.add(item);
        });
        sell.getItems().addAll(items);
        BeanUtils.copyProperties(dto, sell);
    }
}