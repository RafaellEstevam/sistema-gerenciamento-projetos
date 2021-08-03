package br.com.empresa.sistemaGerenciamentoProjetos.specifications;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import br.com.empresa.sistemaGerenciamentoProjetos.model.Cargo;
import br.com.empresa.sistemaGerenciamentoProjetos.model.Funcionario;

/**
 * @author Rafaell Estevam
 *
 */
//select f from Funcionario f where f.cargo = :cargo and day(f.dataContratacao) = :dia and month(f.dataContratacao) = :mes and year(f.dataContratacao) = :ano
//and f.salario between :valor1 and :valor2;
public class FuncionarioSpecification {
	
	//f.cargo = :cargo
	public static Specification<Funcionario>cargo(Cargo cargo){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cargo"), cargo);
	}
	
	
	//day(f.dataContratacao) = :dia 
	public static Specification<Funcionario>dia(Integer dia){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.function("day", Integer.class, root.get("dataContratacao")), dia);
	}
	
	
	//and month(f.dataContratacao) = :mes
	public static Specification<Funcionario>mes(Integer mes){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.function("month", Integer.class, root.get("dataContratacao")), mes);
	}
	
	
	//year(f.dataContratacao) = :ano
	public static Specification<Funcionario>ano(Integer ano){
		return(root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.function("year", Integer.class, root.get("dataContratacao")), ano);
	}
	
	
	//f.salario between :valor1 and :valor2
	public static Specification<Funcionario>salarioBetween(BigDecimal valor1, BigDecimal valor2){
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get("salario"), valor1, valor2);
	}
	
	
	
	
	
	
	
	
	
	
}






