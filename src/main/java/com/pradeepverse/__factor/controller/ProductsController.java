package com.pradeepverse.__factor.controller;

import com.pradeepverse.__factor.model.ProductDTO;
import com.pradeepverse.__factor.model.ProductEntity;
import com.pradeepverse.__factor.repository.mssql.ProductsRepository;
import com.pradeepverse.__factor.service.mongo.ProductsMongoRepositoryService;
import com.pradeepverse.__factor.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsRepository productsRepository;
    private final ProductsMongoRepositoryService productsMongoRepositoryService;
    private final CommonUtil commonUtil;

    // TODO: Error handling
    // TODO: Profiling
    // TODO: Spring security
    // TODO: Implement messaging like RabbitMQ or similar

    @GetMapping("/sql/products/all/v1")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductEntity> all = this.productsRepository.findAll();
        List<ProductDTO> mappedProducts = commonUtil.mapList(all, ProductDTO.class);
        return new ResponseEntity<>(mappedProducts, HttpStatus.ACCEPTED);
    }

    @GetMapping("/mongo/products/all/v1")
    public ResponseEntity<List<ProductDTO>> getAllProductsFromMongo() {
        List<ProductDTO> retrievedProductDtos = this.productsMongoRepositoryService.findAllProducts();
        return new ResponseEntity<>(retrievedProductDtos, HttpStatus.ACCEPTED);
    }

    @PostMapping("mongo/product/add/v1")
    public ResponseEntity<ProductDTO> saveProductInfo(@RequestBody ProductDTO productDTO) {
        for (int i = 0; i < 100; i++) {
            ProductDTO newProductDto = new ProductDTO()
                    .setProductId(100000 + i)
                    .setProductName(productDTO.getProductName())
                    .setProductDescription(productDTO.getProductDescription());
            this.productsMongoRepositoryService.saveProductInfo(newProductDto);
        }
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

}
