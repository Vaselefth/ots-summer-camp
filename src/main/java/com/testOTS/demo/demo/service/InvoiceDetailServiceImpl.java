package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.dao.InvoiceDetailRepository;
import com.testOTS.demo.demo.entity.InvoiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService{

    private InvoiceDetailRepository invoiceDetailRepository;

    @Autowired
    public InvoiceDetailServiceImpl(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    @Override
    public List<InvoiceDetail> findAll() {
        return invoiceDetailRepository.findAll();
    }

    @Override
    public InvoiceDetail findById(long theId) {
        Optional<InvoiceDetail> result = invoiceDetailRepository.findById(theId);

        InvoiceDetail theInvoiceDetail = null;

        if (result.isPresent()) {
            theInvoiceDetail = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find invoice detail id - " + theId);
        }

        return theInvoiceDetail;
    }

    @Override
    public void save(InvoiceDetail theInvoiceDetail) {
        invoiceDetailRepository.save(theInvoiceDetail);
    }

    @Override
    public void deleteById(long theId) {
        invoiceDetailRepository.deleteById(theId);
    }
}
