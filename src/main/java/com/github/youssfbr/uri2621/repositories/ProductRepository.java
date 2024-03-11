package com.github.youssfbr.uri2621.repositories;

import com.github.youssfbr.uri2621.dtos.ProductDTO;
import com.github.youssfbr.uri2621.entities.Product;
import com.github.youssfbr.uri2621.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query( nativeQuery = true,
            value = "SELECT pd.name " +
                    "FROM products pd " +
                    "INNER JOIN providers pv " +
                    "ON pd.id_providers = pv.id " +
                    "WHERE pd.amount BETWEEN :min AND :max " +
                    "AND pv.name LIKE CONCAT(:beginName, '%')")
    List<ProductProjection> showSql(int min, int max, String beginName);

    @Query( "SELECT new com.github.youssfbr.uri2621.dtos.ProductDTO(obj.name) " +
            "FROM Product obj " +
            "WHERE obj.amount BETWEEN :min AND :max " +
            "AND obj.provider.name LIKE CONCAT(:beginName, '%')")
    List<ProductDTO> showJpql(int min, int max, String beginName);

}
