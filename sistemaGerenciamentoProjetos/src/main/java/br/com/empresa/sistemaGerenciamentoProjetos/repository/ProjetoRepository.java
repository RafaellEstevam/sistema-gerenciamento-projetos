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

import br.com.empresa.sistemaGerenciamentoProjetos.model.Projeto;
import br.com.empresa.sistemaGerenciamentoProjetos.model.ProjetoProjecao;

/**
 * @author Rafaell Estevam
 *
 */
@Repository
public interface ProjetoRepository extends PagingAndSortingRepository<Projeto, Long>, JpaSpecificationExecutor<Projeto>{
	
	List<Projeto>findByNomeContaining(String nome, Pageable pageable);
	
	List<Projeto>findByDataContratacaoBetween(LocalDate data1, LocalDate data2,  Pageable pageable);
	
	List<Projeto>findByClienteCnpj(String cnpj, Sort sort);
	
	@Query(value = "select * from Projeto where valor > :valor", nativeQuery = true)
	List<ProjetoProjecao>findByValorGreaterThan(BigDecimal valor);
	
	
}
