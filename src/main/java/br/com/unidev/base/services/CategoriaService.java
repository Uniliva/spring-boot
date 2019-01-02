package br.com.unidev.base.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unidev.base.bomain.Categoria;
import br.com.unidev.base.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository dao;

	public List<Categoria> findAll() {
		return dao.findAll();
	}

	public Optional<Categoria> buscar(Integer id) {
		return dao.findById(id);
	}

	public void salvar(Categoria categoria) {
		dao.save(categoria);
	}

}
