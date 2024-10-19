package com.tiendav_virtual.tienda_virtual.products.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiendav_virtual.tienda_virtual.products.models.dtos.ClockDTO;
import com.tiendav_virtual.tienda_virtual.products.models.entities.Clock;
import com.tiendav_virtual.tienda_virtual.products.services.ClockServices;

@RestController
public class ClockController {
    private final ClockServices clockServices;

    public ClockController(ClockServices clockServices) {
        this.clockServices = clockServices;
    }

    @PostMapping("/clocks")
    public void selectClock(@RequestBody ClockDTO clockDTO) {
        clockServices.createClock(clockDTO);
    }

    @GetMapping("/clocks")
    public List<ClockDTO> findClocks() {
        return clockServices.findClocks();
    }

    @PostMapping("/clocks/purchase/{id}")
    public String purchaseClock(@PathVariable Long id) {
        try {
            clockServices.purchaseClock(id);
            return "Compra realizada con éxito";
        } catch (Exception e) {
            return "Error en la compra: " + e.getMessage();
        }
    }

    @GetMapping("/clocks/verify/{id}")
    public List<Clock> verifyNonVerifiedClocks(@PathVariable Long id) {
        try {
            clockServices.verifyClock(id);
            return clockServices.findNonVerifiedClocks();
        } catch (Exception e) {
            return null;
        }
    }

}
