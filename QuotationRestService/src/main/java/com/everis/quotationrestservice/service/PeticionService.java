package com.everis.quotationrestservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.quotationrestservice.model.Peticion;
import com.everis.quotationrestservice.model.Servicio;
import com.everis.quotationrestservice.repository.ClienteRepository;
import com.everis.quotationrestservice.repository.ServicioRepository;

@Service
public class PeticionService {

	@Autowired
	ClienteRepository clienteRepositorio;
	
	@Autowired
	ServicioRepository servicioRepositorio;
	
	public Peticion generarpeticion (Peticion peticion) {
		peticion.setCliente(clienteRepositorio.findById(peticion.getCliente().getId()).get());
		List<Servicio> listadeservicios = new ArrayList<Servicio>();
		for (Servicio servicio : peticion.getListadeservicios()) {
			listadeservicios.add(servicioRepositorio.findById(servicio.getId()).get());
		}
		peticion.setListadeservicios(listadeservicios);
		return peticion;
	}
}
