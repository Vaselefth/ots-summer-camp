package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    public List<Invoice> findAll();

    public Invoice findById(long theId);

    public void save(Invoice invoice);

    public void deleteById(long theId);
}