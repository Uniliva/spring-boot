package br.com.unidev.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unidev.base.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
