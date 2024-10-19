package com.tiendav_virtual.tienda_virtual.products.services;

import java.util.List;

import com.tiendav_virtual.tienda_virtual.products.models.dtos.ClockDTO;
import com.tiendav_virtual.tienda_virtual.products.models.entities.Clock;

public interface ClockServices {
    void createClock(ClockDTO clockDTO);
    List<ClockDTO> findClocks();
    void purchaseClock(long id);
    List<Clock> findNonVerifiedClocks();
    void verifyClock(long id);
    void processNonVerifiedClocks();
}
