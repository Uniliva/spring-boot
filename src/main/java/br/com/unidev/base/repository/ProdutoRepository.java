package br.com.unidev.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unidev.base.bomain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
