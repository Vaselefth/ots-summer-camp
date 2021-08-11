package com.testOTS.demo.demo.rest;

import com.testOTS.demo.demo.entity.ProductService;
import com.testOTS.demo.demo.service.ProductServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductServiceRestController {

    private ProductServiceService productServiceService;

    @Autowired
    public ProductServiceRestController(ProductServiceService productServiceService) {
        this.productServiceService = productServiceService;
    }

    @GetMapping("/productService")
    public List<ProductService> findAll() {
        return productServiceService.findAll();
    }

    @GetMapping("/productService/{productServiceId}")
    public ProductService getProductService(@PathVariable long productServiceId) {

        ProductService productService = productServiceService.findById(productServiceId);

        if(productService == null) {
            throw new RuntimeException("Product/Service Id not found"+ productServiceId);
        }

        return productService;
    }

    @PostMapping("/productService")
    public ProductService addProductService(@RequestBody ProductService productService) {

        productService.setId(0);

        productServiceService.save(productService);

        return productService;
    }

    @PutMapping("/productService")
    public ProductService updateProductService(@RequestBody ProductService productService) {

        productServiceService.save(productService);

        return productService;
    }

    @DeleteMapping("/productService/{productServiceId}")
    public String deleteproductService(@PathVariable long productServiceId) {

        ProductService productService = productServiceService.findById(productServiceId);

        if (productService == null) {
            throw new RuntimeException("Product/Service id not found - " +productServiceId);
        }

        productServiceService.deleteById(productServiceId);

        return "Deleted product/service id - " + productServiceId;
    }
}
