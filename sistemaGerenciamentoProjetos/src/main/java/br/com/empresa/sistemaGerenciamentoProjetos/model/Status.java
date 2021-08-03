package br.com.empresa.sistemaGerenciamentoProjetos.model;

/**
 * @author Rafaell Estevam
 *
 */

public enum Status {

	CONCLUIDO("Concluído"), ATRASADO("Atrasado"), ADIADO("Adiado"), NAOINICIADO("Não iniciado"), CANCELADO("Cancelado"),
	DENTRODOPRAZO("Dentro do prazo"), TENDENCIADEATRASO("Tendência de atraso");

	private String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
