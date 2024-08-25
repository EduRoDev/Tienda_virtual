package com.tiendav_virtual.tienda_virtual.products.services.implement;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tiendav_virtual.tienda_virtual.products.models.dtos.ClockDTO;
import com.tiendav_virtual.tienda_virtual.products.services.ClockServices;



@Service
public class ClockServicesImpl implements ClockServices{
    
    @Override
    public List<ClockDTO> findClocks(){
        System.out.println("Finding clocks");
        List<ClockDTO> clocks = Arrays.asList(
            new ClockDTO(1, "abc-123", "Omega", "2023", "Rolex", 10, 1500.0),
            new ClockDTO(2, "dfe-456", "Breitling", "2020", "Rolex", 5, 1800.0)
        );
        return clocks;
    }

    @Override
    public void selectClock(ClockDTO clockDTO) {
        System.out.println("Selecting clock");
    }    
}
