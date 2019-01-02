package br.com.unidev.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unidev.base.bomain.Estado;
import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.repository.EstadoRepository;

@Service
public class EstadoService {
	@Autowired
	EstadoRepository dao;

	public Estado buscar(Integer id) throws NotFoundException {
		return dao.findById(id).orElseThrow(()-> new NotFoundException("Estado não encontrado"));
	}
}
