package br.com.unidev.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unidev.base.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
