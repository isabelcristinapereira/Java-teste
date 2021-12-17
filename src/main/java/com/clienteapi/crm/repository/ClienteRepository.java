package com.clienteapi.crm.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clienteapi.crm.model.Cliente;

@Repository 
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
 // vamos usar o list e option o list quando quisermos pesquisar um monte de informação, instancia
	Optional<Cliente> findById(Long id);
	
	Optional<Cliente> findByNome(String nome);
}
 