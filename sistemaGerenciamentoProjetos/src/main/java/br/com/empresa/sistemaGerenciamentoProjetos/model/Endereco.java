package br.com.empresa.sistemaGerenciamentoProjetos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Rafaell Estevam
 *
 */
@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String endereco;
	private Integer numero;
	private String cep;

	@ManyToOne
	private Estado estado;
	@ManyToOne
	private Cidade cidade;
	@ManyToOne
	private Bairro bairro;

	/**
	 * 
	 */
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public Endereco(String endereco, Integer numero, String cep, Estado estado, Cidade cidade, Bairro bairro) {
		super();
		this.endereco = endereco;
		this.numero = numero;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return endereco + ", " + numero +" - "+ bairro.getNome()+" - "+cidade.getNome();
	}
	
	
}
