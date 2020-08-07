package com.ufps.edu.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accesovisitante")
public class AccesoVisitante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private Date fecha;
	
	private Long temperatura;
	
	private Long visitante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Long temperatura) {
		this.temperatura = temperatura;
	}

	public Long getVisitante() {
		return visitante;
	}

	public void setVisitante(Long visitante) {
		this.visitante = visitante;
	}
	
	

}
