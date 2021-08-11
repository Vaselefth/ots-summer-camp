package com.testOTS.demo.demo.rest;

import com.testOTS.demo.demo.entity.InvoiceType;
import com.testOTS.demo.demo.service.InvoiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceTypeRestController {

    private InvoiceTypeService invoiceTypeService;

    @Autowired
    public InvoiceTypeRestController(InvoiceTypeService invoiceTypeService) {
        this.invoiceTypeService = invoiceTypeService;
    }

    @GetMapping("/invoicetypes")
    public List<InvoiceType> findAll() {
        return invoiceTypeService.findAll();
    }

    @GetMapping("/invoicetypes/{invoicetypeId}")
    public InvoiceType getInvoiceType(@PathVariable long invoicetypeId) {

        InvoiceType invoiceType = invoiceTypeService.findById(invoicetypeId);

        if(invoiceType == null) {
            throw new RuntimeException("Vat Id not found"+ invoicetypeId);
        }

        return invoiceType;
    }

    @PostMapping("/invoicetypes")
    public InvoiceType addInvoiceType(@RequestBody InvoiceType invoiceType) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        invoiceType.setId(0);

        invoiceTypeService.save(invoiceType);

        return invoiceType;
    }

    // add mapping for PUT /invoicetypes - update existing invoicetype

    @PutMapping("/invoicetypes")
    public InvoiceType updateInvoiceType(@RequestBody InvoiceType invoiceType) {

        invoiceTypeService.save(invoiceType);

        return invoiceType;
    }

    // add mapping for DELETE /invoicetypes/{invoicetypesId} - delete invoicetypes

    @DeleteMapping("/invoicetypes/{invoicetypeId}")
    public String deleteInvoiceType(@PathVariable long invoicetypeId) {

        InvoiceType invoiceType = invoiceTypeService.findById(invoicetypeId);

        // throw exception if null

        if (invoiceType == null) {
            throw new RuntimeException("Invoice type id not found - " +invoicetypeId);
        }

        invoiceTypeService.deleteById(invoicetypeId);

        return "Deleted invoicetype id - " + invoicetypeId;
    }
}
