package com.ufps.edu.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ufps.edu.model.entity.Visitante;

public interface IVisitanteDao extends JpaRepository<Visitante, Long>{

	Optional<Visitante> findByDocumento(String documento);
	
}
