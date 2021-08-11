package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.entity.ProductService;

import java.util.List;

public interface ProductServiceService {

    public List<ProductService> findAll();

    public ProductService findById(long theId);

    public void save(ProductService productService);

    public void deleteById(long theId);
}
