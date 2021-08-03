package br.com.empresa.sistemaGerenciamentoProjetos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author Rafaell Estevam
 *
 */
@Entity
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal salario;
	private LocalDate dataContratacao;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JoinColumn(unique = true)
	private Endereco endereco;

	@ManyToOne
	private Cargo cargo;

	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "funcionario_unidade", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "unidade_id"))
	private List<UnidadeEmpresarial> unidades;

	@ManyToMany(mappedBy = "funcionarios", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Projeto> projetos;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String nome, BigDecimal salario, LocalDate dataContratacao, Endereco endereco ,Cargo cargo,
			List<UnidadeEmpresarial> unidades) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.dataContratacao = dataContratacao;
		this.endereco = endereco;
		this.cargo = cargo;
		this.unidades = unidades;
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

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<UnidadeEmpresarial> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<UnidadeEmpresarial> unidades) {
		this.unidades = unidades;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

}
