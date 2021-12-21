package com.clienteapi.crm.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clienteapi.crm.model.Cliente;
import com.clienteapi.crm.repository.ClienteRepository;
import com.clienteapi.crm.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	/**
	* Endpoint de requisição Get para buscar cliente pelo Id
	* @since 1.0
	* @author Isabel Cristina
	*
	*/
	@GetMapping("/{id_cliente}") 
	public ResponseEntity<Object>buscarClientePeloId (@PathVariable(value="id_cliente")Long id) { //object que vai ter masi de um itpo de retorno
		Optional<Object> clienteEncontrado = clienteService.buscarClientePeloId(id); //tenta encontrar o cliente pelo parametro passado pela url, quando passamos pelo postmam vamos pela url para pesquisar o cliente,vai pegar o numero do id e transofmrar em um atributo numerico dentro do java
		if(clienteEncontrado.isEmpty()) {   //faz a pesquisa pelo service e se tiver vai gravar no option e se nao tiver ele vai estar vazio e quando tiver vazio traz o status 204
			return ResponseEntity.status(204).build(); //vazio 
			
		} else {
			return ResponseEntity.status(200).body(clienteEncontrado); //se  tiver traz o status 200 e o cliente encontrado no corpo de resposta
		}
		
		
		
	}
	
	/**
	* Endpoint de requisição Post para salvar cliente na aplicação
	* @since 1.0
	* @author Isabel Cristina
	*
	*/
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarCliente(@Valid @RequestBody Cliente novoCliente) {
		Optional<Object> objetoCadastrado = clienteService.salvarCliente(novoCliente);

		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build(); 
		}

	}
	
	/**
	* Endpoint de requisição Get para listar todos os clientes na aplicação
	* @since 1.0
	* @author Isabel Cristina
	*
	*/
	@GetMapping("/todos")
	public ResponseEntity<Object> listarTodosOsClientes(){
		
	List<Cliente> listCliente= clienteService.listarTodosOsClientes();
	if(listCliente.isEmpty()) {
		return ResponseEntity.status(204).build(); //vazio
		
	} else {
		return ResponseEntity.status(200).body(listCliente);
	}
	
	}

}
