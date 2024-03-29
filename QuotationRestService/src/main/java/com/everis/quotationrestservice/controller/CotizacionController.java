package com.everis.quotationrestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.quotationrestservice.model.ComputeResponse;
import com.everis.quotationrestservice.model.Peticion;
import com.everis.quotationrestservice.proxy.CotizacionServiceProxy;
import com.everis.quotationrestservice.service.PeticionService;

@RestController
public class CotizacionController {
	
	@Autowired
	PeticionService peticionServicio;
	
	@Autowired
	CotizacionServiceProxy cotizacionproxy;
	
	@PostMapping("/cotizacion")
	public Peticion cotizar(@RequestBody Peticion peticion) {
		return peticionServicio.generarpeticion(peticion);
	}
	
	@GetMapping("/cotizacion")
	public ComputeResponse resultado (@RequestBody Peticion peticion) {
		return cotizacionproxy.cotizar(peticion);
	}
}
