package com.ecommerce.microcommerce;

import com.ecommerce.microcommerce.entities.Product;
import com.ecommerce.microcommerce.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MicrocommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrocommerceApplication.class, args);
    }


   @Bean
    public CommandLineRunner start(ProductRepository productRepository){

        return  args -> {
            productRepository.save(new Product(null ,"TV LG",125.00));
            productRepository.save(new Product(null ,"Phone",1500.00));
        };
    }

}
