package com.testOTS.demo.demo.dao;

import com.testOTS.demo.demo.entity.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductServiceRepository extends JpaRepository<ProductService,Long> {

}