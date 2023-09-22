package ztgg.project.ecommerce.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ztgg.project.ecommerce.ecommerce.model.Product;

import static ztgg.project.ecommerce.ecommerce.impl.ProductServiceImpl.products;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		Product product1 = Product.builder().
				name("bed").category("furniture").id(123).description("bed").price(55)
						.build();
		Product product2 = Product.builder().
				name("banana").category("food").id(38).description("fruit").price(3)
				.build();
		products.add(product1);
		products.add(product2);
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
