package br.com.unidev.base.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unidev.base.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	CategoriaService serve;

	@GetMapping("/{id}")
	ResponseEntity<?> findByFiltro(@PathVariable Integer id) {
		return this.serve.buscar(id).map(categoria -> ResponseEntity.ok(categoria))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
