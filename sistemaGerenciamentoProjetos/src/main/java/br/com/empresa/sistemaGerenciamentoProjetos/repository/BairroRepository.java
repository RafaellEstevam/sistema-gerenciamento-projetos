package br.com.empresa.sistemaGerenciamentoProjetos.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.sistemaGerenciamentoProjetos.model.Bairro;

/**
 * @author Rafaell Estevam
 *
 */
@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long>{
	
	List<Bairro>findByCidadeId(Long cidadeId, Sort sort);
	
	
	
	
	
}
