package com.pradeepverse.__factor.controller;

import com.pradeepverse.__factor.model.ProductDTO;
import com.pradeepverse.__factor.model.ProductEntity;
import com.pradeepverse.__factor.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/products/all/v1")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> all = this.productsRepository.findAll();
        System.out.println(all);
        return new ResponseEntity<>(all, HttpStatusCode.valueOf(200));
    }

}
