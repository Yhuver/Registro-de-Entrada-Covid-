package com.ufps.edu.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufps.edu.model.entity.Registro;

public interface IRegistroDao extends JpaRepository<Registro, Long>{
	
	

}
