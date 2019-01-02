package br.com.unidev.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unidev.base.bomain.Produto;
import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository dao;

	public Produto buscar(Integer id) throws NotFoundException {
		return dao.findById(id).orElseThrow(()-> new NotFoundException("Produto não encontrado"));
	}

}
