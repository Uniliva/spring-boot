package br.com.unidev.base.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"), QUITADO(2, "Cancelado"), CANCELADO(3, "Quitado");

	private Integer codigo;
	private String descricao;

	private EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

	public static EstadoPagamento toEnum(Integer codigo) {
		if (codigo == null)
			return null;

		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (x.getCodigo().equals(codigo))
				return x;
		}

		throw new IllegalArgumentException();
	}

}
