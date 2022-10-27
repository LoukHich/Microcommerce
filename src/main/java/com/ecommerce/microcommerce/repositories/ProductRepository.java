package com.ecommerce.microcommerce.repositories;


import com.ecommerce.microcommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {

     Product findByPrix(double prix);
}
