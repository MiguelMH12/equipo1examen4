package com.everis.quotationrestservice.model;

import java.util.List;

public class Peticion {

	private Cliente cliente;
	private List<Servicio> listadeservicios;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Servicio> getListadeservicios() {
		return listadeservicios;
	}
	public void setListadeservicios(List<Servicio> listadeservicios) {
		this.listadeservicios = listadeservicios;
	}
	
}
