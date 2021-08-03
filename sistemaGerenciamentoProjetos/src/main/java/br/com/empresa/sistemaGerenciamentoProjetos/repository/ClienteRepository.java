package br.com.empresa.sistemaGerenciamentoProjetos.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.sistemaGerenciamentoProjetos.model.Cliente;
import br.com.empresa.sistemaGerenciamentoProjetos.model.ClienteProjecao;

/**
 * @author Rafaell Estevam
 *
 */
@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente>{

	
	List<Cliente> findByRazaoSocialContaining(String razaoSocial, Pageable pageable);
	
	@Query(value = "select razao_social, cnpj, telefone from cliente where cnpj = :cnpj", nativeQuery = true)
	ClienteProjecao findByCnpj(String cnpj);
	
	Cliente findByProjetosNome(String nomeProjeto);
	
	
	
}
