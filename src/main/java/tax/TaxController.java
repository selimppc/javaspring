package tax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tax.entity.Tax;
import tax.services.TaxService;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @ResponseBody
    @GetMapping("/taxes")
    public List<Tax> getTaxes(){
        return taxService.getAllTaxes();
    }

    @ResponseBody
    @PostMapping("/taxes")
    public ResponseEntity<?> addTax(@RequestBody Tax tax){
        // taxService.addTax(tax);
        return new ResponseEntity<>(tax, HttpStatus.CREATED);
    }



}
