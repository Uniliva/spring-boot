package br.com.unidev.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unidev.base.domain.Cliente;
import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository dao;

	public Cliente find(Integer id) throws NotFoundException {
		return dao.findById(id).orElseThrow(()-> new NotFoundException("Cliente não encontrado"));
	}


}
