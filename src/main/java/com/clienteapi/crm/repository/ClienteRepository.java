package com.clienteapi.crm.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clienteapi.crm.model.Cliente;

@Repository 
public interface ClienteRepository extends JpaRepository<Cliente, Long>{ 
	
	/**
	* Método ultilizado para selecionar apenas um cliente por Id
	* @since 1.0
	* @author Isabel Cristina
	*
	*/
    Optional<Cliente> findById(Long id);
	
    /**
	* Método ultilizado para selecionar apenas um cliente por nome
	* @since 1.0
	* @author Isabel Cristina
	*
	*/
	Optional<Cliente> findByNome(String nome);
}
 