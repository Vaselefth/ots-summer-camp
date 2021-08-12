package com.testOTS.demo.demo.rest;

import com.testOTS.demo.demo.entity.Vat;
import com.testOTS.demo.demo.service.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VatRestController {

    private VatService vatService;

    @Autowired
    public VatRestController(VatService vatService) {
        this.vatService = vatService;
    }

    @GetMapping("/vats")
    public List<Vat> findAll() {
        return vatService.findAll();
    }

    @GetMapping("/vats/{vatId}")
    public Vat getVat(@PathVariable long vatId) {

        Vat vat = vatService.findById(vatId);

        if(vat == null) {
            throw new RuntimeException("Vat Id not found"+ vatId);
        }

        return vat;
    }

    @PostMapping("/vats")
    public Vat addVat(@RequestBody Vat vat) {

        vat.setId(0);

        vatService.save(vat);

        return vat;
    }

                @PutMapping("/vats")
    public Vat updateVat(@RequestBody Vat vat) {

        vatService.save(vat);

        return vat;
    }

    @DeleteMapping("/vats/{vatId}")
    public String deleteVat(@PathVariable long vatId) {

        Vat vat = vatService.findById(vatId);

        if (vat == null) {
            throw new RuntimeException("Vat id not found - " +vatId);
        }

        vatService.deleteById(vatId);

        return "Deleted vat id - " + vatId;
    }
}
