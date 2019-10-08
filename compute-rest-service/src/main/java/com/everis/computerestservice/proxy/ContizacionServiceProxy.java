package com.everis.computerestservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.everis.computerestservice.model.Peticion;
import com.everis.computerestservice.request.QuotationRestServiceRequest;

@FeignClient(name = "QUOTATIONSERVICE")
public interface ContizacionServiceProxy {
	
	@PostMapping("/cotizacion")
	public Peticion cotizar(@RequestBody Peticion peticion);

}
