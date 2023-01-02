package com.lcrtech.productregistration.controller;

import com.lcrtech.productregistration.model.Client;
import com.lcrtech.productregistration.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ModelAndView listClients(RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView("clients");
        mav.addObject("clients", clientService.listClients());
        mav.addObject(new Client());

        return mav;
    }

    @PostMapping
    public String save(Client client) {
        clientService.saveClient(client);

        return "redirect:/";
    }

   @GetMapping("/edit/{id}")
   public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("clients");
        mav.addObject("client", clientService.findClientById(id));
        mav.addObject("clients", clientService.listClients());

        return mav;
   }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes ra) {

        clientService.deleteClient(id);

        ra.addFlashAttribute("success", "Cliente excluído com sucesso.");

        return "redirect:/";
    }
}
