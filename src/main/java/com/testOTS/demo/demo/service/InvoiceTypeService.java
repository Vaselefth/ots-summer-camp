package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.entity.InvoiceType;

import java.util.List;

public interface InvoiceTypeService {

    public List<InvoiceType> findAll();

    public InvoiceType findById(long theId);

    public void save(InvoiceType invoiceType);

    public void deleteById(long theId);
}