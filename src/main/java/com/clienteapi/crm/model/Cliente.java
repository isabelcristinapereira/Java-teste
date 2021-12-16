package com.clienteapi.crm.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
* Classe Cliente utilizada como entidade para registrar usuarios no Banco de dados. mapeamento no banco de dados
* @since 1.0
* @author Isabel Cristina
*
*/

@Entity
@Table(name= "tbl_cliente") 
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	
	@NotBlank /** trabalha na camada da model, ele faz a validação aqui na model, verifica erro aqui na model*/
	private String nome;
	
	private String telefone;
	
	
	 private LocalDate dataNascimento;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	} 


}  