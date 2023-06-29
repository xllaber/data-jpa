package com.llacerximo.spring.datajpa.controller;

import com.llacerximo.spring.datajpa.models.entity.Client;
import com.llacerximo.spring.datajpa.models.entity.Invoice;
import com.llacerximo.spring.datajpa.models.entity.Product;
import com.llacerximo.spring.datajpa.models.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/invoice")
@SessionAttributes("invoice")
public class InvoiceController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/form/{clientId}")
    public String create(@PathVariable Long clientId, Model model, RedirectAttributes flash) {
        Client client = clientService.getById(clientId);
        if(client == null) {
            flash.addFlashAttribute("error", "Client not found or doesn't exist");
            return "redirect:clients";
        }
        Invoice invoice = new Invoice();
        invoice.setClient(client);
        model.addAttribute("invoice", invoice);
        model.addAttribute("title", "New Invoice");
        return "invoice/form";
    }

    @GetMapping(value = "/load-prodoucts/{term}", produces = {"application/jason"})
    public @ResponseBody List<Product> loadProducts(@PathVariable String term) {
        return clientService.findByName(term);
    }

}
