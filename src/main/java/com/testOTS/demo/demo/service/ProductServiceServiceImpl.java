package com.testOTS.demo.demo.service;

import com.testOTS.demo.demo.dao.ProductServiceRepository;
import com.testOTS.demo.demo.entity.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceServiceImpl implements ProductServiceService {

    private ProductServiceRepository productServiceRepository;

    @Autowired
    public ProductServiceServiceImpl(ProductServiceRepository productServiceRepository) {
        this.productServiceRepository = productServiceRepository;
    }

    @Override
    public List<ProductService> findAll() {
        return productServiceRepository.findAll();
    }

    @Override
    public ProductService findById(long theId) {
        Optional<ProductService> result = productServiceRepository.findById(theId);

        ProductService theProductService = null;

        if (result.isPresent()) {
            theProductService = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find product-service id - " + theId);
        }

        return theProductService;
    }

    @Override
    public void save(ProductService theProductService) {
        productServiceRepository.save(theProductService);
    }

    @Override
    public void deleteById(long theId) {
        productServiceRepository.deleteById(theId);
    }
}
