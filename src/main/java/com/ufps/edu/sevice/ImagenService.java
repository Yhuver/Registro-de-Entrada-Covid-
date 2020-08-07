package com.ufps.edu.sevice;

import org.springframework.stereotype.Service;

@Service
public class ImagenService {

	private String imagen;

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
