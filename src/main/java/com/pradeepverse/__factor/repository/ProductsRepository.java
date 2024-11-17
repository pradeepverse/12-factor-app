package com.pradeepverse.__factor.repository;

import com.pradeepverse.__factor.model.ProductDTO;
import com.pradeepverse.__factor.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Long> {
    @Override
    List<ProductEntity> findAll();
}
