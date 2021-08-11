package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.dao.InvoiceTypeRepository;
import com.testOTS.demo.demo.entity.InvoiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceTypeImpl implements InvoiceTypeService {

    private InvoiceTypeRepository invoiceTypeRepository;

    @Autowired
    public InvoiceTypeImpl(InvoiceTypeRepository invoiceTypeRepository) {
        this.invoiceTypeRepository = invoiceTypeRepository;
    }

    @Override
    public List<InvoiceType> findAll() {
        return invoiceTypeRepository.findAll();
    }

    @Override
    public InvoiceType findById(long theId) {
        Optional<InvoiceType> result = invoiceTypeRepository.findById(theId);

        InvoiceType invoiceType = null;

        if(result.isPresent()) {
            invoiceType = result.get();
        }
        else {
            throw new RuntimeException("Did not found that invoicetypeID" + theId);
        }

        return invoiceType;
    }

    @Override
    public void save(InvoiceType invoiceType) {
        invoiceTypeRepository.save(invoiceType);
    }

    @Override
    public void deleteById(long theId) {
        invoiceTypeRepository.deleteById(theId);
    }
}
