package com.tiendav_virtual.tienda_virtual.products.models.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClockDTO {
    private int id;
    private String sku;
    private String name;
    private String model;
    private String brand;
    private int quantity;
    private double price;
}
