package br.com.unidev.base.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.unidev.base.domain.Categoria;
import br.com.unidev.base.exceptions.BusinessException;
import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository dao;

	public Categoria find(Integer id) {
		return dao.findById(id).orElseThrow(()-> new NotFoundException("Categoria não encontrado"));
	}

	public Categoria insert(Categoria categoria) {		
		categoria.setId(null);
		return dao.save(categoria);
	}

	public Categoria update(Categoria categoria) throws NotFoundException {
		find(categoria.getId());
		return dao.save(categoria);
	}

	public void delete(Integer id) throws NotFoundException {
		find(id);
		try {
		
		dao.deleteById(id);
		
		}catch (DataIntegrityViolationException e) {
			throw new BusinessException("Não é possivel apagar uma categoria a que tenha produtos");
		}
	}

	public List<Categoria> findAll() {
		return dao.findAll();
	}

}
