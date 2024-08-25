package com.tiendav_virtual.tienda_virtual.products.models.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clock {
    private int id;
    private String sku;
    private String name;
    private String model;
    private String brand;
    private int quantity;
    private double price;
    private List<Category> categories;

}
