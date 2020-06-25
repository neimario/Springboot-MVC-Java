package br.com.jcavi.javaweb.sisvendas.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;

@Entity
@Audited
@Data
public class Cliente extends BaseEntity {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -8973478584952214689L;

	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message="Nome é obrigatório")
	private String nome;
	
	@NotEmpty(message="E-mail é obrigatório")
	@Email(message="E-mail inválido")
	private String email;
	
	@NotEmpty(message="Senha é obrigatório")	
	@Length(min=2,max=8,message="A senha deve possuir no mínimo 2 e no máximo 8 caracteres")
	private String senha;
	
	@NotNull(message="Idade é obrigatório")
	@Min(value=18,message="Não são permitidos cadastros de clientes menores de 18 anos")
	private Integer idade;
	private String prof;

	private Endereco teste;


	// mappedBy -> indica o nome do atributo na classe (entidade) ManyToOne da relação
	//@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	//@NotEmpty(message="Pelo menos 1 endereço é obrigatório")
	//private List<Endereco> enderecos = new ArrayList<>();

}