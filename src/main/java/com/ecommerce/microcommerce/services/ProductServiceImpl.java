package com.ecommerce.microcommerce.services;

import com.ecommerce.microcommerce.entities.Product;
import com.ecommerce.microcommerce.exceptions.RequestApiException;
import com.ecommerce.microcommerce.repositories.ProductRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements  ProductService{


    private final ProductRepository productRepository ;

    @Override
    public MappingJacksonValue  getAllProducts() {
        // Listes des produits avant le filtrage
        List<Product> products =productRepository.findAll();
        //une implémentation de PropertyFilter qui permet d'établir les règles de filtrage sur un Bean
        SimpleBeanPropertyFilter monFilter = SimpleBeanPropertyFilter.serializeAllExcept("prix");
        //Les règles de filtrage (monFiltre) peuvent s'appliquer à tous les Beans qui sont annotés avec "filtreDynamique".
        FilterProvider listDesFiltres = new SimpleFilterProvider()
                                                       .addFilter("filterDynamique",monFilter);
        MappingJacksonValue productsFiltred = new MappingJacksonValue(products);
        productsFiltred.setFilters(listDesFiltres);
        return  productsFiltred;
    }

    @Override
    public Product getProduct(Long id) {
       //throw  new RequestApiException("Not Found");
        Product prod = productRepository.findById(id).orElseThrow(()->
                new RequestApiException("not found !!!"));
        return  prod;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductByPrix(double prix) {
        return productRepository.findByPrix(prix);
    }


}
