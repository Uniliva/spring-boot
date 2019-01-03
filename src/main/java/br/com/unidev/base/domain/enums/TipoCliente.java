package br.com.unidev.base.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1, "Pessoa fisica"), PESSOAJURIDICA(2, "Pessoa Juridica");

	private Integer codigo;
	private String descricao;

	private TipoCliente(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) return null;
		for (TipoCliente x : TipoCliente.values()) {
			if (x.getCodigo().equals(cod)) {
				return x;
			}
		}
		throw new IllegalArgumentException();

	}

}
