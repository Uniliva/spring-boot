package br.com.unidev.base.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unidev.base.domain.Endereco;
import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository dao;

	public Endereco buscar(Integer id) throws NotFoundException {
		return dao.findById(id).orElseThrow(()-> new NotFoundException("Endereço não encontrado"));
	}

	public List<Endereco> saveAll(List<Endereco> enderecos) {
		return dao.saveAll(enderecos);		
	}


}
