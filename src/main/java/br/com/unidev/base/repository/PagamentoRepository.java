package br.com.unidev.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unidev.base.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
