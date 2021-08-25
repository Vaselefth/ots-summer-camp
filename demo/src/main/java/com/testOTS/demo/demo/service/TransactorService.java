package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.entity.Transactor;

import java.util.List;

public interface TransactorService {

    public List<Transactor> findAll();

    public Transactor findById(long theId);

    public void save(Transactor theTransactor);

    public void deleteById(long theId);

    public Transactor findByTin(long tin);
}
