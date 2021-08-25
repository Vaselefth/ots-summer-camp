package com.testOTS.demo.demo.dao;

import com.testOTS.demo.demo.entity.Transactor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactorRepository extends JpaRepository<Transactor, Long> {

    Transactor findByTin(long tin);

}
