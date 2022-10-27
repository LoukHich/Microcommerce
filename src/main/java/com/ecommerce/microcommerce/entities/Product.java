package com.ecommerce.microcommerce.entities;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonFilter("filterDynamique")
public class Product {
    @Id
    @ GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @Size(min = 3, max = 25)
    String name ;

   //   @JsonIgnore
    @Min(value = 1)
    double prix;

}
