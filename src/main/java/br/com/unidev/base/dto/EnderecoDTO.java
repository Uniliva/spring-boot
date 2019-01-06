package br.com.unidev.base.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.unidev.base.domain.Cidade;
import br.com.unidev.base.domain.Cliente;
import br.com.unidev.base.domain.Endereco;

public class EnderecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	@NotNull(message="Codigo da Cidade é obrigatorio")
	private Integer codigoCidade;
	
	public EnderecoDTO() {}
	/**
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param bairro
	 * @param cep
	 */
	public EnderecoDTO(String logradouro, String numero, String complemento, String bairro, String cep, Integer codigoCidade ) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.codigoCidade = codigoCidade;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}	
	
	public Integer getCodigoCidade() {
		return codigoCidade;
	}
	public void setCodigoCidade(Integer codigoCidade) {
		this.codigoCidade = codigoCidade;
	}
	public Endereco toEndereco( Cliente cliente,Cidade cidade) {
		return new Endereco(null, logradouro, numero, complemento, bairro, cep, cliente, cidade);
	}
	

}
