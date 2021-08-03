package br.com.empresa.sistemaGerenciamentoProjetos.specifications;

import org.springframework.data.jpa.domain.Specification;

import br.com.empresa.sistemaGerenciamentoProjetos.model.Projeto;
import br.com.empresa.sistemaGerenciamentoProjetos.model.Status;

/**
 * @author Rafaell Estevam
 *
 */
//select p from Projeto p where p.status = :status and day(p.dataContratacao) = :dia 
//and month(p.dataContratacao) = :mes and year(p.dataContratacao) = :year;
public class ProjetoSpecification {
	
	
	//p.status = :status
	public static Specification<Projeto>status(Status status){
		return(root, criteriaQuery,criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
	}
	
	
	//day(p.dataContratacao) = :dia
	public static Specification<Projeto> dia(Integer dia){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.function("day", Integer.class,root.get("dataContratacao")), dia);
	}
	

	//month(p.dataContratacao) = :mes
	public static Specification<Projeto>mes(Integer mes){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.function("month", Integer.class, root.get("dataContratacao")), mes);
	}
	
	
	//year(p.dataContratacao) = :year
	public static Specification<Projeto>ano(Integer ano){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.function("year", Integer.class, root.get("dataContratacao")), ano);
	}
}
