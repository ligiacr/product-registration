package com.lcrtech.productregistration.controller;

import com.lcrtech.productregistration.model.Sell;
import com.lcrtech.productregistration.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        mav.addObject(new Sell());

        return mav;
    }

}
