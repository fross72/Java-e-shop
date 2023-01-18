package com.fross72.ecommerce.models;

import jakarta.persistence.*;


import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue()
    private UUID id;
    private String name;
    private String description;
    private int price;
    private String imageURL;

    public Product() {
    }

    public Product(String name, String description, int price, String imageURL) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageURL = imageURL;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
