package com.pradeepverse.__factor.service.mongo;

import com.pradeepverse.__factor.model.ProductDTO;
import com.pradeepverse.__factor.model.ProductMongoEntity;
import com.pradeepverse.__factor.repository.mongo.ProductsMongoRepository;
import com.pradeepverse.__factor.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductsMongoRepositoryService {

    private final ProductsMongoRepository productsMongoRepository;
    private final ModelMapper modelMapper;
    private final CommonUtil commonUtil;

    public List<ProductDTO> findAllProducts() {
        List<ProductMongoEntity> all = this.productsMongoRepository.findAll();
        return commonUtil.mapList(all, ProductDTO.class);
    }

    @Async("customTaskExecutor")
    public void saveProductInfo(ProductDTO productDTO) {
        log.info("Current thread details " + Thread.currentThread().getName());
        ProductMongoEntity productMongoEntity = modelMapper.map(productDTO, ProductMongoEntity.class);
        ProductMongoEntity savedProductMongoEntity = this.productsMongoRepository.save(productMongoEntity);
    }

}
