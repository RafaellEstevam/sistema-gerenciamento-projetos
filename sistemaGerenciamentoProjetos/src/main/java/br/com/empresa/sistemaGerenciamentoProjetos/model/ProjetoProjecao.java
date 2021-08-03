package br.com.empresa.sistemaGerenciamentoProjetos.model;

import java.math.BigDecimal;

/**
 * @author Rafaell Estevam
 *
 */
public interface ProjetoProjecao {
	
	String getNome();
	
	BigDecimal getValor();
	
	Cliente getCliente();
}
