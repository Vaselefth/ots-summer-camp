package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.entity.Vat;

import java.util.List;

public interface VatService {

    public List<Vat> findAll();

    public Vat findById(long theId);

    public void save(Vat vat);

    public void deleteById(long theId);
}