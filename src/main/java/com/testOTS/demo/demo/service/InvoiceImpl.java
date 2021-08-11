package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.dao.InvoiceRepository;
import com.testOTS.demo.demo.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(long theId) {
        Optional<Invoice> result = invoiceRepository.findById(theId);

        Invoice invoice = null;

        if(result.isPresent()) {
            invoice = result.get();
        }
        else {
            throw new RuntimeException("Did not found that invoiceId" + theId);
        }

        return invoice;
    }

    @Override
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public void deleteById(long theId) {
        invoiceRepository.deleteById(theId);
    }
}
