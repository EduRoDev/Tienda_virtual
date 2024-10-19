package com.tiendav_virtual.tienda_virtual.products.models.dtos;

import com.tiendav_virtual.tienda_virtual.products.models.entities.EstadoPago;

public class ClockDTO {
    private Long id;
    private String sku;
    private String name;
    private String model;
    private String brand;
    private int quantity;
    private double price;
    private EstadoPago estadoPago;
    private Boolean verificado;

    

    
    public ClockDTO(Long id, String sku, String name, String model, String brand, int quantity, double price,
            EstadoPago estadoPago, Boolean verificado) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;
        this.estadoPago = estadoPago;
        this.verificado = verificado;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }
    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }
    public Boolean getVerificado() {
        return verificado;
    }
    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }
}
