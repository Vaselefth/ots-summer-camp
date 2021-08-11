package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.dao.VatRepository;
import com.testOTS.demo.demo.entity.Vat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VatServiceImpl implements VatService {

    private VatRepository vatRepository;

    @Autowired
    public VatServiceImpl(VatRepository vatRepository) {
        this.vatRepository = vatRepository;
    }

    @Override
    public List<Vat> findAll() {
        return vatRepository.findAll();
    }

    @Override
    public Vat findById(long theId) {
        Optional<Vat> result = vatRepository.findById(theId);

        Vat vat = null;

        if(result.isPresent()) {
            vat = result.get();
        }
        else {
            throw new RuntimeException("Did not found that vatId"+ theId);
        }

        return vat;
    }

    @Override
    public void save(Vat vat) {
        vatRepository.save(vat);
    }

    @Override
    public void deleteById(long theId) {
        vatRepository.deleteById(theId);
    }
}
