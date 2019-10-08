package com.everis.computerestservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.computerestservice.model.Cotizacion;
import com.everis.computerestservice.model.Peticion;
import com.everis.computerestservice.model.Servicio;
import com.everis.computerestservice.proxy.ContizacionServiceProxy;
import com.everis.computerestservice.request.QuotationRestServiceRequest;
import com.everis.computerestservice.response.ComputeResponse;
import com.everis.computerestservice.service.OperacionesService;

@RestController
public class OperacionesController {

	@Autowired
	private OperacionesService operacionesService;
	
	@Autowired
	ContizacionServiceProxy contizacionServiceProxy; 
	
	@PostMapping("/cotizacion")
	public ComputeResponse calculaCotizacion(@RequestBody Peticion request) {
		request=contizacionServiceProxy.cotizar(request);
		ComputeResponse respuesta = new ComputeResponse();
		if(request.equals(null) || request.getCliente().getTipocliente() < 0
				|| request.getListadeservicios().isEmpty()) {
			respuesta.setSuccessful(false);
			respuesta.setMessage("Bad rest : petición vacia");
			respuesta.setCliete(request.getCliente());
			respuesta.setServicios(request.getListadeservicios());
		}else {
			Cotizacion cotizacion = new Cotizacion();
			List<Servicio> servicios = request.getListadeservicios();
			
			cotizacion.setSubtotal(operacionesService.calcularSumatoria(servicios));
			cotizacion.setDescuento(operacionesService.calcularDescuento(
					request.getCliente().getTipocliente(), cotizacion.getSubtotal()));
			cotizacion.setSubtotalcondescuento(operacionesService.calcularSubtotal(
					cotizacion.getSubtotal(), cotizacion.getDescuento()));
			cotizacion.setIva(operacionesService.calcularIVA(cotizacion.getSubtotalcondescuento()));
			cotizacion.setTotal(operacionesService.calcularTotal(
					cotizacion.getSubtotalcondescuento(), cotizacion.getIva()));
			
			respuesta.setSuccessful(true);
			respuesta.setMessage("Operación exitosa");
			respuesta.setCliete(request.getCliente());
			respuesta.setServicios(servicios);
			respuesta.setCotizacion(cotizacion);
		}
		
		return respuesta;
	}
}
