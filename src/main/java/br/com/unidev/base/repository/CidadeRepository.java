package br.com.unidev.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unidev.base.bomain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
