package br.com.empresa.sistemaGerenciamentoProjetos.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.sistemaGerenciamentoProjetos.model.Cidade;

/**
 * @author Rafaell Estevam
 *
 */
@Repository
public interface CidadeRepository extends PagingAndSortingRepository<Cidade, Long>{
	
	List<Cidade>findByEstadoId(Long estadoId, Sort sort);
}
