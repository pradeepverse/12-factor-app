package com.pradeepverse.__factor.controller;

import com.pradeepverse.__factor.model.ProductDTO;
import com.pradeepverse.__factor.model.ProductEntity;
import com.pradeepverse.__factor.model.ProductMongoEntity;
import com.pradeepverse.__factor.repository.mongo.ProductsMongoRepository;
import com.pradeepverse.__factor.repository.mssql.ProductsRepository;
import com.pradeepverse.__factor.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsRepository productsRepository;
    private final ProductsMongoRepository productsMongoRepository;
    private final CommonUtil commonUtil;

    @GetMapping("/sql/products/all/v1")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductEntity> all = this.productsRepository.findAll();
        List<ProductDTO> mappedProducts = commonUtil.mapList(all, ProductDTO.class);
        return new ResponseEntity<>(mappedProducts, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/mongo/products/all/v1")
    public ResponseEntity<List<ProductDTO>> getAllProductsFromMongo() {
        List<ProductMongoEntity> all = this.productsMongoRepository.findAll();
        List<ProductDTO> mappedProducts = commonUtil.mapList(all, ProductDTO.class);
        return new ResponseEntity<>(mappedProducts, HttpStatusCode.valueOf(200));
    }

}
