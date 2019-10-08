package com.everis.computerestservice.response;

import java.util.List;

import com.everis.computerestservice.model.Cliente;
import com.everis.computerestservice.model.Cotizacion;
import com.everis.computerestservice.model.Servicio;

public class ComputeResponse {

	private boolean successful;
	private String message;
	private Cliente cliete;
	private List<Servicio> servicios;
	private Cotizacion cotizacion;
	
	@Override
	public String toString() {
		return "ComputeResponse [successful=" + successful + ", message=" + message + ", cliete=" + cliete
				+ ", servicios=" + servicios + ", cotizacion=" + cotizacion + "]";
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Cliente getCliete() {
		return cliete;
	}

	public void setCliete(Cliente cliete) {
		this.cliete = cliete;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}
	
	
}
