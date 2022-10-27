package com.ecommerce.microcommerce.controllers;

import com.ecommerce.microcommerce.entities.Product;
import com.ecommerce.microcommerce.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Objects;
@Api("API pour les opérations CRUD sur les produits.")
@RestController

@RequiredArgsConstructor
public class ProductControler {

   private  final ProductService productService;

   @GetMapping("products")
    public MappingJacksonValue getProducts(){

        return  productService.getAllProducts();

    }

    @ApiOperation(value = "Récupère un produit grâce à son ID à condition que celui-ci soit en stock!")
    @GetMapping(path = "products/{id}")
    public Product getProductById(@PathVariable Long id ){
         return productService.getProduct(id);

    }

    @GetMapping(path = "/test/products/{prix}")
    public Product getProductByPrix(@PathVariable double prix ){
        return productService.getProductByPrix(prix);

    }

    @PostMapping("/products/{product}")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product ){
        Product productAdded = productService.saveProduct(product);
        if(Objects.isNull(productAdded)){
            return  ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
//    @PostMapping("/products/{product}")
//    public  Product saveProduct(@RequestBody Product product ){
//        return productService.saveProduct(product);
//    }

    @PutMapping("/products/{product}")
    public Product updateaProduct(@RequestBody Product product){
        return   productService.saveProduct(product);

        }
    @DeleteMapping("products/{id}")

    public void deleteProduct(@PathVariable Long id ){

        productService.deleteProduct(id);
    }

}
