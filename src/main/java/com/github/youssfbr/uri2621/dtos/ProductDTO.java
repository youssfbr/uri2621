package com.github.youssfbr.uri2621.dtos;

import com.github.youssfbr.uri2621.projections.ProductProjection;

public class ProductDTO {
    private String name;

    public ProductDTO() { }

    public ProductDTO(String name) {
        this.name = name;
    }

    public ProductDTO(ProductProjection projection) {
        name = projection.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
