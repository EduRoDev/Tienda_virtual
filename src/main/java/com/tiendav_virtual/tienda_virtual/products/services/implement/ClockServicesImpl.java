package com.tiendav_virtual.tienda_virtual.products.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiendav_virtual.tienda_virtual.products.models.dtos.ClockDTO;
import com.tiendav_virtual.tienda_virtual.products.models.entities.Clock;
import com.tiendav_virtual.tienda_virtual.products.models.entities.EstadoPago;
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
                        clock.getPrice(),
                        clock.getEstadoPago(),
                        clock.getVerificado()))
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
        clock.setEstadoPago(EstadoPago.PENDIENTE);
        clock.setVerificado(false);
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
        clock.setEstadoPago(EstadoPago.APROBADO);
        clock.setVerificado(false);
        clockRepository.save(clock);
    }

    @Override
    public List<Clock> findNonVerifiedClocks() {
        return clockRepository.findByEstadoPagoInAndVerificadoFalse(List.of(EstadoPago.PENDIENTE, EstadoPago.APROBADO));
    }

    @Override
    public void verifyClock(long id) {
        Clock clock = clockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reloj no encontrado"));
        clock.setVerificado(true);  
        clockRepository.save(clock);
    }

    @Override
    @Transactional
    @Scheduled(fixedRate = 5000)
    public void processNonVerifiedClocks(){
        List<Clock> nonVerifiedClocks = findNonVerifiedClocks();
        nonVerifiedClocks.forEach(clock -> {
            System.out.println("Verificando reloj: " + clock.getSku() + " con id: " + clock.getId() + " y estado: " + clock.getEstadoPago());
            verifyClock(clock.getId());
        });
    }

}
