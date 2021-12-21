package com.clienteapi.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.clienteapi.crm.model.Cliente;
import com.clienteapi.crm.repository.ClienteRepository;
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	/**
	* Método ultilizado para buscar cliente por Id pela classe ClienteRepository
	* @since 1.0
	* @author Isabel Cristina
	*
	*/
	public Optional<Object> buscarClientePeloId(Long id) {

		Optional<Cliente> clienteSalvo = clienteRepository.findById(id);

		if (clienteSalvo.isEmpty()) {

			return Optional.empty(); //retorno objeto vazio
		} 

		return Optional.ofNullable(clienteSalvo.get()); 
	}
	
	/**
	* Método ultilizado para salvar cliente na base de dados
	* @since 1.0
	* @author Isabel Cristina
	*
	*/
	public Optional<Object> salvarCliente(Cliente novoCliente) {
		Optional<Cliente> cliente = clienteRepository.findByNome(novoCliente.getNome());
		if (cliente.isPresent()) {
			return Optional.empty();
		} else {
			
			return Optional.ofNullable(clienteRepository.save(novoCliente));
		}
	}
  
	/**
	* Método ultilizado para buscar todos os clientes na base de dados
	* @since 1.0
	* @author Isabel Cristina
	*
	*/
	public List<Cliente> listarTodosOsClientes(){
		return clienteRepository.findAll();
		
	}

}
