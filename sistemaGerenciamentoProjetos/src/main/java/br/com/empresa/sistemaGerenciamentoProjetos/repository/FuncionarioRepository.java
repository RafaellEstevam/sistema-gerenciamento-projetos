package br.com.empresa.sistemaGerenciamentoProjetos.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.sistemaGerenciamentoProjetos.model.Funcionario;
import br.com.empresa.sistemaGerenciamentoProjetos.model.FuncionarioDTO;

/**
 * @author Rafaell Estevam
 *
 */
@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Long>, JpaSpecificationExecutor<Funcionario>{
	
	List<Funcionario>findByNomeContaining(String nome, Pageable pageable);
	
	List<Funcionario>findBySalarioGreaterThan(BigDecimal valor, Pageable pageable);
	
	List<Funcionario>findBySalarioLessThan(BigDecimal valor, Pageable pageable);
	
	List<Funcionario>findBySalarioBetween(BigDecimal valor1, BigDecimal valor2, Pageable pageable);
	
	@Query("select new br.com.empresa.sistemaGerenciamentoProjetos.model.FuncionarioDTO(f.nome, f.endereco, f.dataContratacao) from Funcionario f where f.dataContratacao between :data1 and :data2")
	List<FuncionarioDTO>findByDataContratacaoBetween(LocalDate data1, LocalDate data2);
	
	
	List<Funcionario>findByCargoNomeContaining(String nomeCargo, Sort sort);
	
	
}
