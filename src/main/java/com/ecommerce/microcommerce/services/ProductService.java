package com.ecommerce.microcommerce.services;

import com.ecommerce.microcommerce.entities.Product;
import org.springframework.http.converter.json.MappingJacksonValue;

import java.util.List;

public interface ProductService {

     MappingJacksonValue getAllProducts();

     Product getProduct(Long id);

     Product saveProduct(Product product);

     void deleteProduct(Long id);

     Product getProductByPrix(double prix);
}
