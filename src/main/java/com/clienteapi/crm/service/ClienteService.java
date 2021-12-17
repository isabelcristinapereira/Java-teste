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

	public Optional<Cliente> buscarClientePeloId(Long id) {

		Optional<Cliente> clienteSalvo = clienteRepository.findById(id);

		if (clienteSalvo.isEmpty()) {

			return Optional.empty(); //retorno objeto vazio
		} 

		return Optional.ofNullable(clienteSalvo.get()); 
	}
 
	public Optional<Object> salvarCliente(Cliente novoCliente) {
		Optional<Cliente> cliente = clienteRepository.findByNome(novoCliente.getNome());
		if (cliente.isPresent()) {
			return Optional.empty();
		} else {
			
			return Optional.ofNullable(clienteRepository.save(novoCliente));
		}
	}
  
	public List<Cliente> listarTodosOsClientes(){
		return clienteRepository.findAll();
		
	}

}
