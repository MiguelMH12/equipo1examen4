package com.everis.quotationrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.quotationrestservice.model.Peticion;
import com.everis.quotationrestservice.service.PeticionService;

@RestController
public class CotizacionController {
	
	@Autowired
	PeticionService peticionServicio;
	
	@PostMapping("/cotizacion")
	public Peticion cotizar(@RequestBody Peticion peticion) {
		return peticionServicio.generarpeticion(peticion);
	}
	
}
