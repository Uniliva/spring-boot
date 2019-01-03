package br.com.unidev.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unidev.base.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
