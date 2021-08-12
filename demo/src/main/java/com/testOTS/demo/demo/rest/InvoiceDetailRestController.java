package com.testOTS.demo.demo.rest;

import com.testOTS.demo.demo.entity.InvoiceDetail;
import com.testOTS.demo.demo.service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceDetailRestController {

    private InvoiceDetailService invoiceDetailService;

    @Autowired
    public InvoiceDetailRestController(InvoiceDetailService invoiceDetailService) {
        this.invoiceDetailService = invoiceDetailService;
    }

    // expose "/InvoiceDetails" and return list of invoice details
    @GetMapping("/invoiceDetails")
    public List<InvoiceDetail> findAll() {
        return invoiceDetailService.findAll();
    }

    // add mapping for GET /invoiceDetails/{invoiceDetailId}

    @GetMapping("/invoiceDetails/{invoiceDetailId}")
    public InvoiceDetail getInvoiceDetail(@PathVariable long invoiceDetailId) {

        InvoiceDetail theInvoiceDetail = invoiceDetailService.findById(invoiceDetailId);

        if (theInvoiceDetail == null) {
            throw new RuntimeException("Invoice Detail id not found - " + invoiceDetailId);
        }

        return theInvoiceDetail;
    }

    // add mapping for POST /invoiceDetails - add new invoiceDetail

    @PostMapping("/invoiceDetails")
    public InvoiceDetail addInvoiceDetail(@RequestBody InvoiceDetail theInvoiceDetail) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theInvoiceDetail.setId(0);

        invoiceDetailService.save(theInvoiceDetail);

        return theInvoiceDetail;
    }

    // add mapping for PUT /invoiceDetails - update existing invoiceDetail

    @PutMapping("/invoiceDetails")
    public InvoiceDetail updateInvoiceDetail(@RequestBody InvoiceDetail theInvoiceDetail) {

        invoiceDetailService.save(theInvoiceDetail);

        return theInvoiceDetail;
    }

    // add mapping for DELETE /invoiceDetails/{invoiceDetailId} - delete invoiceDetail

    @DeleteMapping("/invoiceDetails/{invoiceDetailId}")
    public String deleteInvoiceDetail(@PathVariable long invoiceDetailId) {

        InvoiceDetail tempInvoiceDetail = invoiceDetailService.findById(invoiceDetailId);

        // throw exception if null

        if (tempInvoiceDetail == null) {
            throw new RuntimeException("InvoiceDetail id not found - " + invoiceDetailId);
        }

        invoiceDetailService.deleteById(invoiceDetailId);

        return "Deleted invoiceDetail id - " + invoiceDetailId;
    }
}
