package com.avatar.user.tax.service;


import com.avatar.user.tax.entity.Tax;
import com.avatar.user.tax.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxService {

    @Autowired
    TaxRepository taxRepository;

    public List<Tax> getAllTaxes(){
        return (List<Tax>) taxRepository.findAll();
    }

    public void addTax(Tax tax){
        // custom
        taxRepository.save(tax);
    }
}
