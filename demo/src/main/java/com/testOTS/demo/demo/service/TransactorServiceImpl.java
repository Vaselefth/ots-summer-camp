package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.dao.TransactorRepository;
import com.testOTS.demo.demo.entity.Transactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactorServiceImpl implements TransactorService {

    private TransactorRepository transactorRepository;

    @Autowired
    public TransactorServiceImpl(TransactorRepository transactorRepository) {
        this.transactorRepository = transactorRepository;
    }

    @Override
    public List<Transactor> findAll() {
        return transactorRepository.findAll();
    }

    @Override
    public Transactor findById(long theId) {
        Optional<Transactor> result = transactorRepository.findById(theId);

        Transactor transactor = null;

        if(result.isPresent()) {
            transactor = result.get();
        }
        else {
            throw new RuntimeException("Did not found that transactorId"+ theId);
        }

        return transactor;
    }

    @Override
    public Transactor findByTin(long tin) {
        Transactor result = transactorRepository.findByTin(tin);

        if(result == null) {
            throw new RuntimeException("Did not found that TIN"+tin);
        }

        return result;
    }

    @Override
    public void save(Transactor transactor) {
        transactorRepository.save(transactor);
    }

    @Override
    public void deleteById(long theId) {
        transactorRepository.deleteById(theId);
    }
}
