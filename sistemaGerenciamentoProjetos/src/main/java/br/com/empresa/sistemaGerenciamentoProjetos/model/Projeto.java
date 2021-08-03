package br.com.empresa.sistemaGerenciamentoProjetos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Rafaell Estevam
 *
 */
@Entity
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate dataContratacao;
	private BigDecimal valor;
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne
	private Cliente cliente;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "projeto_funcionario", joinColumns = @JoinColumn(name = "projeto_id"), inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
	private List<Funcionario> funcionarios;

	
	public Projeto() {
		
	}

	public Projeto(String nome, LocalDate dataContratacao, BigDecimal valor, Status status, Cliente cliente,
			List<Funcionario> funcionarios) {
		super();
		this.nome = nome;
		this.dataContratacao = dataContratacao;
		this.valor = valor;
		this.status = status;
		this.cliente = cliente;
		this.funcionarios = funcionarios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public String toString() {
		return "nome=" + nome;
	}

	
	
	
}
