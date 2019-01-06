package br.com.unidev.base.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.unidev.base.domain.Cliente;
import br.com.unidev.base.dto.ClienteDTO;
import br.com.unidev.base.exceptions.BusinessException;
import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository dao;

	public Cliente find(Integer id) throws NotFoundException {
		return dao.findById(id).orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
	}

	public Cliente insert(Cliente Cliente) {
		Cliente.setId(null);
		return dao.save(Cliente);
	}

	public Cliente update(ClienteDTO objDTO) throws NotFoundException {
		Cliente obj = find(objDTO.getId());
		update(obj, objDTO);
		return dao.save(obj);
	}

	public void delete(Integer id) throws NotFoundException {
		find(id);
		try {

			dao.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new BusinessException("Não é possivel apagar uma Cliente a que tenha produtos");
		}
	}

	public List<Cliente> findAll() {
		return dao.findAll();
	}

	/**
	 * 
	 * @param page             - Numero da pagina a ser retonada
	 * @param itensPorPagina   - quantidade de item que devem ser retornado
	 * @param OrdenadoPor      - item a ser usado para ordenar, [ex: id, nome ..]
	 * @param direcaoOrdenação - Direção da ordenação se ASC ou DESC
	 * @return
	 */
	public Page<Cliente> findPage(Integer page, Integer itensPorPagina, String OrdenadoPor, String direcaoOrdenação) {
		PageRequest request = PageRequest.of(page, itensPorPagina, Direction.valueOf(direcaoOrdenação), OrdenadoPor);
		return dao.findAll(request);

	}

	private void update(Cliente obj, ClienteDTO objDTO) {
		obj.setEmail(objDTO.getEmail());
		obj.setNome(objDTO.getNome());
	}

}
