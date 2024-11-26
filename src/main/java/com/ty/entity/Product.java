package com.ty.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
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
    private Category category;

    // Getters and Setters
    
}

