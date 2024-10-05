package com.tiendav_virtual.tienda_virtual.products.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiendav_virtual.tienda_virtual.products.models.dtos.ClockDTO;
import com.tiendav_virtual.tienda_virtual.products.models.entities.Clock;
import com.tiendav_virtual.tienda_virtual.products.repositories.ClockRepository;
import com.tiendav_virtual.tienda_virtual.products.services.ClockServices;



@Service
public class ClockServicesImpl implements ClockServices{
    
    @Autowired
    private ClockRepository clockRepository;


    @Override
    public List<ClockDTO> findClocks(){
        List<Clock> clocks = clockRepository.findAll();
    
        System.out.println("Cantidad de relojes encontrados: " + clocks.size());
    
        return clocks.stream()
                .map(clock -> new ClockDTO(
                        clock.getId(),
                        clock.getSku(),
                        clock.getName(),
                        clock.getModel(),
                        clock.getBrand(),
                        clock.getQuantity(),
                        clock.getPrice()))
                .toList();
    }

    @Override
    public void createClock(ClockDTO clockDTO) {
        Clock clock = new Clock();
        clock.setSku(clockDTO.getSku() != null ? clockDTO.getSku() : "DEFAULT-SKU");
        clock.setName(clockDTO.getName());
        clock.setModel(clockDTO.getModel());
        clock.setBrand(clockDTO.getBrand());
        clock.setQuantity(clockDTO.getQuantity());
        clock.setPrice(clockDTO.getPrice());
        clockRepository.save(clock);
    }
    
    
    @Override
    @Transactional 
    public void purchaseClock(long id) {
        
        Clock clock = clockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reloj no encontrado"));
        
        if (clock.getQuantity() <= 0) {
            throw new RuntimeException("No hay stock disponible para este reloj");
        }
        
        clock.setQuantity(clock.getQuantity() - 1);
        clockRepository.save(clock);
    }
}
