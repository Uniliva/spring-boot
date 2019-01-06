package br.com.unidev.base.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ClienteNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Campo Obrigatorio!")
	@Size(min = 5, max = 120, message = "O nome deve ter de 5 a 120 caracteres")
	private String nome;
	@Email(message = "O e-mail invalido!")
	private String email;
	private String cpfOuCnpj;
	@NotNull (message = "Campo Obrigatorio!")
	private Integer tipoCliente;
	
	@NotEmpty (message = "Campo Obrigatorio!")
	private List<EnderecoDTO> enderecos = new ArrayList<>();

	private Set<String> telefones = new HashSet<>();

	public ClienteNewDTO() {

	}

	/**
	 * @param nome
	 * @param email
	 * @param cpfOuCnpj
	 * @param tipoCliente
	 * @param enderecos
	 * @param telefones
	 * @param codigoCidade
	 */
	public ClienteNewDTO(String nome, String email, String cpfOuCnpj, Integer tipoCliente, List<EnderecoDTO> enderecos,
			Set<String> telefones, Integer codigoCidade) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipoCliente = tipoCliente;
		this.enderecos = enderecos;
		this.telefones = telefones;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDTO> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}



}
