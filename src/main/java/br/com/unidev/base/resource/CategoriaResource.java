package br.com.unidev.base.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.unidev.base.domain.Categoria;
import br.com.unidev.base.dto.CategoriaDTO;
import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	CategoriaService service;

	@GetMapping("")
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<CategoriaDTO> listaDTO = service.findAll().stream().map(cat -> new CategoriaDTO(cat)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findByFiltro(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.find(id));
	}
	
	@PostMapping("")
	public ResponseEntity<Void> insert(@RequestBody Categoria categoria){
		Categoria obj = service.insert(categoria);	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Categoria categoria ) {
		service.update(categoria);	
		return ResponseEntity.noContent().build();		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id ) throws NotFoundException{
		service.delete(id);	
		return ResponseEntity.noContent().build();		
	}
}
