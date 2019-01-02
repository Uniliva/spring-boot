package br.com.unidev.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unidev.base.bomain.Cidade;
import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.repository.CidadeRepository;

@Service
public class CidadeService {
	@Autowired
	CidadeRepository dao;

	public Cidade buscar(Integer id) throws NotFoundException {
		return dao.findById(id).orElseThrow(()-> new NotFoundException("Cidade não encontrado"));
	}


}
