package demo.taxes.services;


import demo.taxes.entity.Taxes;
import demo.taxes.repository.TaxesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxesService {

    @Autowired
    TaxesRepository taxesRepository;

    public List<Taxes> getAllTaxes(){
        return (List<Taxes>) taxesRepository.findAll();
    }

    public Taxes addTax(Taxes taxes){
        return taxesRepository.save(taxes);
    }

}
