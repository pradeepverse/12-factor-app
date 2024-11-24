package com.pradeepverse.__factor.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductDTO {
    private long productId;
    private String productName;
    private String productDescription;
}
