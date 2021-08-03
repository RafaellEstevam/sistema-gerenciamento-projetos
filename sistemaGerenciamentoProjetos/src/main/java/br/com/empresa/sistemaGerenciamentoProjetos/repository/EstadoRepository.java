package br.com.empresa.sistemaGerenciamentoProjetos.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.sistemaGerenciamentoProjetos.model.Estado;

/**
 * @author Rafaell Estevam
 *
 */
@Repository
public interface EstadoRepository extends PagingAndSortingRepository<Estado, Long>{
	
	
}
