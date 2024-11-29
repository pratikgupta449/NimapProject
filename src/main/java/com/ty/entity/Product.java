package com.ty.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
//@JsonPropertyOrder({"id", "name", "price", "description", "category"}) // Specify the order here
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    private Double price;
    private String Description;

    // Many Products can belong to one Category
    @ManyToOne
    @JoinColumn(name = "category_id") // Foreign key to Category
    @JsonIgnoreProperties("products") // Prevents infinite recursion
    private Category category;

    // Getters and Setters
    
}

