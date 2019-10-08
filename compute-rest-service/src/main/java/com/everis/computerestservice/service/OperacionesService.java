package com.everis.computerestservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.computerestservice.model.Servicio;

@Service
public class OperacionesService {

	private Double cotizacionPrivado = new Double(10);
	private Double cotizacionGobierno = new Double(0);
	private Double cotizacionPreferente = new Double(25);
	private Double iva = new Double(0.16);
	
	public Double calcularSumatoria(List<Servicio> servicios) {
		Double sumatoriaServicios = 0.0;
		if(!servicios.isEmpty()) {
			for (Servicio servicio : servicios) {
				sumatoriaServicios = sumatoriaServicios + servicio.getCosto();
			}
		}
		return sumatoriaServicios;
	}
	
	public Double calcularDescuento(int tipoCliente, Double sumatoria) {
		Double descuento = null;
		if(tipoCliente==1) {
			descuento = cotizacionPrivado;
		}else if (tipoCliente==2) {
			descuento = cotizacionGobierno;
		}else if (tipoCliente==3) {
			descuento = cotizacionPreferente;
		}
		descuento = descuento / 100;
		descuento = sumatoria * descuento;
		return descuento;	
	}
	
	public Double calcularSubtotal(Double sumatoria, Double descuento) {
		return sumatoria - descuento;
	}
	
	public Double calcularIVA(Double subTotal) {
		return subTotal*iva;
	}
	
	public Double calcularTotal(Double subTotal, Double ivaResultante) {
		return subTotal+ivaResultante;
	}
}
