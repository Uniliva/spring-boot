package br.com.unidev.base.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unidev.base.domain.Pedido;
import br.com.unidev.base.exceptions.NotFoundException;
import br.com.unidev.base.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository dao;

	public Pedido buscar(Integer id) throws NotFoundException {
		return dao.findById(id).orElseThrow(()-> new NotFoundException("Categoria não encontrado"));
	}


}
