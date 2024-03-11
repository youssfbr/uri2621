package com.github.youssfbr.uri2621;

import com.github.youssfbr.uri2621.dtos.ProductDTO;
import com.github.youssfbr.uri2621.projections.ProductProjection;
import com.github.youssfbr.uri2621.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	private final ProductRepository productRepository;

    public Uri2621Application(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		final List<ProductDTO> resultSql = productRepository.showSql(10 , 20 , "P")
				.stream()
				.map(ProductDTO::new)
				.toList();

		final List<ProductDTO> resultJpql = productRepository.showJpql(10, 20, "P");

		System.out.println("\n*** SQL *******************");
		for (var obj : resultSql) {
			System.out.println(obj);
		}

		System.out.println("\n*** JPQL *******************");
		for (ProductDTO obj : resultJpql) {
			System.out.println(obj);
		}

		System.out.println();
	}
}
