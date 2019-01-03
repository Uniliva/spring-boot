package br.com.unidev.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unidev.base.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
