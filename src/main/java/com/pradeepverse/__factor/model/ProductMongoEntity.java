package com.pradeepverse.__factor.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ProductsInfo")
@Data
public class ProductMongoEntity {
    private long productId;
    private String productName;
    private String productDescription;
}
