package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.entity.InvoiceDetail;

import java.util.List;

public interface InvoiceDetailService {

    public List<InvoiceDetail> findAll();

    public InvoiceDetail findById(long theId);

    public void save(InvoiceDetail invoiceDetail);

    public void deleteById(long theId);
}
