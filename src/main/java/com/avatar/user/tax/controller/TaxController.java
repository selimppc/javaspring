package com.avatar.user.tax.controller;


import com.avatar.user.tax.entity.Tax;
import com.avatar.user.tax.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaxController {

    @Autowired
    TaxService taxService;

    @GetMapping("/taxes")
    public List<Tax> getTaxes(){
        return taxService.getAllTaxes();
    }

    @PostMapping("/taxes")
    public void addTax(@RequestBody Tax tax){
        taxService.addTax(tax);

    }
}
