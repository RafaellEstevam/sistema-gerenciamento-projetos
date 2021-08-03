package br.com.empresa.sistemaGerenciamentoProjetos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.sistemaGerenciamentoProjetos.model.Cargo;

/**
 * @author Rafaell Estevam
 *
 */
@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long>{
	
	List<Cargo> findByNomeContaining(String nome);
}
