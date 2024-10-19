package com.tiendav_virtual.tienda_virtual.products.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Clock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String name;
    private String model;
    private String brand;
    private int quantity;
    private double price;

    @Enumerated(EnumType.STRING)
    private EstadoPago estadoPago;
    private Boolean verificado;

}
