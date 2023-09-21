package ztgg.project.ecommerce.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ztgg.project.ecommerce.ecommerce.model.Product;

import static ztgg.project.ecommerce.ecommerce.impl.ProductServiceImpl.products;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
