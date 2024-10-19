package com.tiendav_virtual.tienda_virtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TiendaVirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaVirtualApplication.class, args);
	}

}
