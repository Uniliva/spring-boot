package br.com.unidev.base.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.unidev.base.domain.Categoria;
import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	CategoriaService repo;

	@GetMapping("/{id}")
	public ResponseEntity<?> findByFiltro(@PathVariable Integer id) throws NotFoundException {
		return ResponseEntity.ok().body(repo.buscar(id));
	}
	
	@PostMapping("")
	public ResponseEntity<Void> insert(@RequestBody Categoria categoria){
		Categoria obj = repo.insert(categoria);	
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}
}
