package br.com.jcavi.javaweb.sisvendas.entity;

import lombok.Data;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Audited

public class Endereco extends BaseEntity {
	private static final long serialVersionUID = -8973478584952214689L;

	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="Nome é obrigatório")
	private String nome;
}