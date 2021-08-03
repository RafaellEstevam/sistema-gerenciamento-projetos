package br.com.empresa.sistemaGerenciamentoProjetos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import br.com.empresa.sistemaGerenciamentoProjetos.model.Funcionario;
import br.com.empresa.sistemaGerenciamentoProjetos.model.Projeto;
import br.com.empresa.sistemaGerenciamentoProjetos.model.Status;
import br.com.empresa.sistemaGerenciamentoProjetos.repository.BairroRepository;
import br.com.empresa.sistemaGerenciamentoProjetos.repository.CargoRepository;
import br.com.empresa.sistemaGerenciamentoProjetos.repository.CidadeRepository;
import br.com.empresa.sistemaGerenciamentoProjetos.repository.ClienteRepository;
import br.com.empresa.sistemaGerenciamentoProjetos.repository.EstadoRepository;
import br.com.empresa.sistemaGerenciamentoProjetos.repository.FuncionarioRepository;
import br.com.empresa.sistemaGerenciamentoProjetos.repository.ProjetoRepository;
import br.com.empresa.sistemaGerenciamentoProjetos.repository.UnidadeEmpresarialRepository;
import br.com.empresa.sistemaGerenciamentoProjetos.specifications.FuncionarioSpecification;
import br.com.empresa.sistemaGerenciamentoProjetos.specifications.ProjetoSpecification;

@SpringBootApplication
public class SistemaEmpresaApplication implements CommandLineRunner {

	private final CargoRepository cargoRepository;
	private final ClienteRepository clienteRepository;
	private final EstadoRepository estadoRepository;
	private final CidadeRepository cidadeRepository;
	private final BairroRepository bairroRepository;
	private final UnidadeEmpresarialRepository unidadeEmpresarialRepository;
	private final FuncionarioRepository funcionarioRepository;
	private final ProjetoRepository projetoRepository;

	public SistemaEmpresaApplication(CargoRepository cargoRepository, ClienteRepository clienteRepository,
			EstadoRepository estadoRepository, CidadeRepository cidadeRepository, BairroRepository bairroRepository,
			UnidadeEmpresarialRepository unidadeEmpresarialRepository, FuncionarioRepository funcionarioRepository,
			ProjetoRepository projetoRepository) {
		super();
		this.cargoRepository = cargoRepository;
		this.clienteRepository = clienteRepository;
		this.estadoRepository = estadoRepository;
		this.cidadeRepository = cidadeRepository;
		this.bairroRepository = bairroRepository;
		this.unidadeEmpresarialRepository = unidadeEmpresarialRepository;
		this.funcionarioRepository = funcionarioRepository;
		this.projetoRepository = projetoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemaEmpresaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
	}

}















/*
 * >>>Criar cliente
 * 
 * Estado estado = new Estado(); estado.setId(1L);
 * 
 * Cidade cidade = new Cidade(); cidade.setId(1L);
 * 
 * Bairro bairro = new Bairro(); bairro.setId(5L);
 * 
 * Endereco endereco = new Endereco("Rua Sebastião Daniel de Sousa", 589,
 * "03547-090", estado, cidade, bairro);
 * 
 * Cliente cliente = new Cliente("Lucca e Arthur Filmagens Ltda",
 * "64.590.406/0001-54", "(11) 3537-6605", endereco);
 * 
 * 
 * clienteRepository.save(cliente);
 * 
 * 
 * 
 * >>>Criar Projeto
 * 
 * LocalDate dataContratacao = LocalDate.parse("2020-09-15");
		  
  BigDecimal valor = BigDecimal.valueOf(15000.00);
 	 
  Cliente cliente = new Cliente(); cliente.setId(1L);
  
  	Iterable<Funcionario>iterable = funcionarioRepository.findAll();
	 List<Funcionario>funcionarios = new ArrayList<Funcionario>();		 
	 
	 for (Funcionario funcionario : iterable) {
		 funcionarios.add(funcionario);
	}
  
  
  Projeto projeto = new Projeto("Reyxuy", dataContratacao, valor, cliente, funcionarios);
 
  projetoRepository.save(projeto);
		  
 * 
 * 
 * >>> Criar Funcionario
 * 
 * 		Estado estado = new Estado(); estado.setId(1L);
		  
		 Cidade cidade = new Cidade(); cidade.setId(1L);
		  
		 Bairro bairro = new Bairro(); bairro.setId(6L);
		
		 Endereco endereco = new Endereco("Rua Villaça Júnior", 238, "03872-010", estado, cidade, bairro);
		
		 Cargo cargo = new Cargo();
		 cargo.setId(1L);
		 
		 Iterable<UnidadeEmpresarial>iterable = unidadeEmpresarialRepository.findAll();
		 List<UnidadeEmpresarial>unidades = new ArrayList<UnidadeEmpresarial>();		 
		 
		 for (UnidadeEmpresarial unidadeEmpresarial : iterable) {
			unidades.add(unidadeEmpresarial);
		}
		 
		 
		 Funcionario f1 = new Funcionario("Leandro Lucca Figueiredo", BigDecimal.valueOf(8200.00), LocalDate.parse("2020-05-22"), endereco, cargo, unidades);
		 
		 funcionarioRepository.save(f1);
		 
		 
>>> Funcionario Specification

// cargo | dia | mes | ano | salario
		
			Cargo cargo = new Cargo(); 
			cargo.setId(2L);
			Integer dia = null;
			Integer mes = null;
			Integer ano = null;
			BigDecimal valor1 = null;//BigDecimal.valueOf(5000.00);
			BigDecimal valor2 = null;// BigDecimal.valueOf(15000.00);
		
			Specification<Funcionario>spec = null;
			
			if(cargo != null) {
				spec = FuncionarioSpecification.cargo(cargo);
			}
			
			
			if(dia != null) {
				if(spec == null) {
					spec = FuncionarioSpecification.dia(dia);
				}else {
					spec = spec.and(FuncionarioSpecification.dia(dia));
				}
			}
			

			if(mes != null) {
				if(spec == null) {
					spec = FuncionarioSpecification.mes(mes);
				}else {
					spec = spec.and(FuncionarioSpecification.mes(mes));
				}
			}
			

			if(ano != null) {
				if(spec == null) {
					spec = FuncionarioSpecification.ano(ano);
				}else {
					spec = spec.and(FuncionarioSpecification.ano(ano));
				}
			}
			

			if(valor1 != null && valor2 != null) {
				if(spec == null) {
					spec = FuncionarioSpecification.salarioBetween(valor1, valor2);
				}else {
					spec = spec.and(FuncionarioSpecification.salarioBetween(valor1, valor2));
				}
			}
			
			
			List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification.where(spec));
			
			for (Funcionario funcionario : funcionarios) {
				System.out.println(funcionario.getNome());
			}
			
			
			
			
		 
		 
		 
		 
		 
 * 
 * 
 * 
 */
