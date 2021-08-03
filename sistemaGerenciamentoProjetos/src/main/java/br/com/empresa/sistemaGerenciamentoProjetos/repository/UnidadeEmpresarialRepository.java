package br.com.empresa.sistemaGerenciamentoProjetos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.sistemaGerenciamentoProjetos.model.UnidadeEmpresarial;

/**
 * @author Rafaell Estevam
 *
 */
@Repository
public interface UnidadeEmpresarialRepository extends CrudRepository<UnidadeEmpresarial, Long>{
		
}
