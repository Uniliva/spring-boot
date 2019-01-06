package br.com.unidev.base.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.unidev.base.domain.Cliente;
import br.com.unidev.base.dto.ClienteDTO;
import br.com.unidev.base.dto.ClienteNewDTO;
import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteRecource {

	@Autowired
	ClienteService service;

	@GetMapping("")
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<ClienteDTO> listaDTO = service.findAll().stream().map(cat -> new ClienteDTO(cat))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findByFiltro(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.find(id));
	}

	@PostMapping("")
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO ClienteDto) {
		Cliente obj = service.insert(ClienteDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO Cliente) {
		service.update(Cliente);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws NotFoundException {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/paginas")
	public ResponseEntity<Page<ClienteDTO>> findPage(
			// definindo que os valores viraão como paremetros da requicição ex
			// /Cliente/page?numero=1&numeroItens=4 ...
			// o defaultValor e para definir um valor caso não seja passado por parametro
			@RequestParam(value = "pagina", defaultValue = "0") Integer page,
			@RequestParam(value = "numeroItens", defaultValue = "24") Integer itensPorPagina,
			@RequestParam(value = "ordenadoPor", defaultValue = "nome") String OrdenadoPor,
			@RequestParam(value = "direcao", defaultValue = "ASC") String direcaoOrdenação) {

		Page<Cliente> PageCliente = service.findPage(page, itensPorPagina, OrdenadoPor, direcaoOrdenação);

		// convertendo uma Page de Cliente para uma page de ClienteDTO objeto que
		// vai ser serializado
		// por page vir com o java ( não e necessario pegar um stream para usar o MAP
		Page<ClienteDTO> PageClienteDTO = PageCliente.map(cat -> new ClienteDTO(cat));

		return ResponseEntity.ok().body(PageClienteDTO);
	}
}
