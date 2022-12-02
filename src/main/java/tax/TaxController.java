package tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tax.entity.Tax;
import tax.services.TaxService;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/tax")
public class TaxController {

    private TaxService taxService;

    @ResponseBody
    @GetMapping("/")
    public List<Tax> getTaxes(){
        return taxService.getAllTaxes();
    }

    @ResponseBody
    @PostMapping("/")
    public ResponseEntity<?> addTax(@RequestBody Tax tax){
        // taxService.addTax(tax);
        return new ResponseEntity<>(tax, HttpStatus.CREATED);
    }



}
