package demo.taxes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import demo.taxes.entity.Taxes;
import demo.taxes.services.TaxesService;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class TaxesController {

    @Autowired
    private TaxesService taxesService;

    @ResponseBody
    @GetMapping("/taxes")
    public List<Taxes> getTaxes(){
        return taxesService.getAllTaxes();
    }

    @ResponseBody
    @PostMapping("/taxes")
    public ResponseEntity<?> addTax(@RequestBody Taxes taxes){
        Taxes tax = taxesService.addTax(taxes);
        return new ResponseEntity<>(tax, HttpStatus.CREATED);
    }



}
