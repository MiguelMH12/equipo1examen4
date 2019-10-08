package com.everis.quotationrestservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.everis.quotationrestservice.model.ComputeResponse;
import com.everis.quotationrestservice.model.Peticion;

@FeignClient(name = "COMPUTE-REST-SERVICE")
public interface CotizacionServiceProxy {
	
	@PostMapping("/cotizacion")
	public ComputeResponse cotizar(@RequestBody Peticion peticion);

}
