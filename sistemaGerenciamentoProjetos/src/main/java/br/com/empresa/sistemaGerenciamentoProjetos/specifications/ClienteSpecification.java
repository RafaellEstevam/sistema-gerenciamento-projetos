package br.com.empresa.sistemaGerenciamentoProjetos.specifications;

import org.springframework.data.jpa.domain.Specification;

import br.com.empresa.sistemaGerenciamentoProjetos.model.Bairro;
import br.com.empresa.sistemaGerenciamentoProjetos.model.Cidade;
import br.com.empresa.sistemaGerenciamentoProjetos.model.Cliente;
import br.com.empresa.sistemaGerenciamentoProjetos.model.Estado;

/**
 * @author Rafaell Estevam
 *
 */
//select c from Cliente c where c.endereco.estado = :estado and c.endereco.cidade = :cidade and c.endereco.bairro = :bairro;
public class ClienteSpecification {
	
	//c.endereco.estado = :estado
	public static Specification<Cliente>estado(Estado estado){
		return(root ,criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("endereco").get("estado"), estado);
	}
	
	//c.endereco.cidade = :cidade
	public static Specification<Cliente>cidade(Cidade cidade){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("endereco").get("cidade"), cidade);
	}
	
	
	//c.endereco.bairro = :bairro
	public static Specification<Cliente>bairro(Bairro bairro){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("endereco").get("bairro"), bairro);
	}
}
