package com.example.lab_project;

import java.io.Serializable;

public class Perfume implements Serializable {
    private int id;
    private String name;
    private String brand;
    private String description;
    private double price;
    private int imageRes;

    public Perfume(int id, String name, String brand, String description, double price, int imageRes) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.imageRes = imageRes;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public int getImageRes() {
        return imageRes;
    }

    // Getters and setters
}