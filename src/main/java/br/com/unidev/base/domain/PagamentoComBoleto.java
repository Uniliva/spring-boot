package br.com.unidev.base.domain;

import java.util.Date;

import javax.persistence.Entity;

import br.com.unidev.base.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Date dataVenciemto;
	private Date dataPagamento;

	public Date getDataVenciemto() {
		return dataVenciemto;
	}

	public void setDataVenciemto(Date dataVenciemto) {
		this.dataVenciemto = dataVenciemto;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public PagamentoComBoleto() {
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVenciemto = dataVencimento;
	}

}
