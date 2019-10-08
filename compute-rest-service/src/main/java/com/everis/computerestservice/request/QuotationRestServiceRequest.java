package com.everis.computerestservice.request;

import java.util.List;

import com.everis.computerestservice.model.Cliente;
import com.everis.computerestservice.model.Servicio;

public class QuotationRestServiceRequest {

	private Cliente cliente;
	private List<Servicio> listadeservicios;
	
	public Cliente getCliete() {
		return cliente;
	}
	public void setCliete(Cliente cliete) {
		this.cliente = cliete;
	}
	public List<Servicio> getServicios() {
		return listadeservicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.listadeservicios = servicios;
	}
	
}
