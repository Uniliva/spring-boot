package br.com.unidev.base.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteRecource {

	@Autowired
	ClienteService service;

	@GetMapping("/{id}")
	ResponseEntity<?> findByFiltro(@PathVariable Integer id) throws NotFoundException {
		return ResponseEntity.ok().body(service.find(id));
	}
}
