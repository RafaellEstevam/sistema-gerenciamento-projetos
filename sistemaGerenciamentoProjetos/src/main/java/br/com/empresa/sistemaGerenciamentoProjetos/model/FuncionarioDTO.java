package br.com.empresa.sistemaGerenciamentoProjetos.model;

import java.time.LocalDate;

/**
 * @author Rafaell Estevam
 *
 */
public class FuncionarioDTO {

	private String nome;
	private Endereco endereco;
	private LocalDate dataContratacao;

	public FuncionarioDTO(String nome, Endereco endereco, LocalDate dataContratacao) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.dataContratacao = dataContratacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", endereco=" + endereco + ", dataContratacao=" + dataContratacao;
	}
	
	
	
}
