package com.everis.quotationrestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.quotationrestservice.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

}
