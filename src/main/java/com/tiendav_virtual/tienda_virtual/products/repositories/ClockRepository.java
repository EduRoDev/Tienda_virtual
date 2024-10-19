package com.tiendav_virtual.tienda_virtual.products.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.tiendav_virtual.tienda_virtual.products.models.entities.Clock;
import com.tiendav_virtual.tienda_virtual.products.models.entities.EstadoPago;

public interface ClockRepository extends ListCrudRepository<Clock, Long> {
    List<Clock> findByEstadoPagoInAndVerificadoFalse(List<EstadoPago> estados);
}