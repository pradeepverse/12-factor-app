package com.pradeepverse.__factor.repository.mongo;

import com.pradeepverse.__factor.model.ProductMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsMongoRepository extends MongoRepository<ProductMongoEntity, Long> {

    @Override
    List<ProductMongoEntity> findAll();

    @Override
    <S extends ProductMongoEntity> S save(S entity);
}
