package br.com.unidev.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unidev.base.domain.Categoria;
import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository dao;

	public Categoria buscar(Integer id) throws NotFoundException {
		return dao.findById(id).orElseThrow(()-> new NotFoundException("Categoria não encontrado"));
	}


}
