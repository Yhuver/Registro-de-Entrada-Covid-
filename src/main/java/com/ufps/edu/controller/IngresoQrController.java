package com.ufps.edu.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ufps.edu.model.dao.IBasicoDao;
import com.ufps.edu.model.dao.IRegistroDao;
import com.ufps.edu.model.entity.Basico;
import com.ufps.edu.model.entity.Registro;
import com.ufps.edu.sevice.ImagenService;

@Controller()
@RequestMapping("/home")
public class IngresoQrController {
	
	@Autowired
	private IBasicoDao basicoDao;
	
	@Autowired
	private IRegistroDao registroDao;
	
	@Autowired
	private ImagenService imagenService;
	
	@GetMapping("qr")
	public String redireccionarQr() {
		return "qr";
	}
	
	@PostMapping("validarQr")
	public String validarQr(@RequestParam String documento, @RequestParam String temperatura, Model model) {
		Optional<Basico> basico=basicoDao.findByDocumento(documento);
		if(!basico.isPresent()) {
			return "qr";
		}else {
			Registro registro=new Registro();
			registro.setTemperatura(Double.parseDouble(temperatura));
			registro.setPersona(basico.get().getId());
			registroDao.save(registro);
			model.addAttribute("imagenSimon", imagenService.getImagen());
			return "home";
		}
	}
}
