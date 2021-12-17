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
	
	@GetMapping("/{id_cliente}")
	public ResponseEntity<Cliente>buscarClientePeloId (@PathVariable(value="id_cliente")Long id) {
		
		return ResponseEntity.status(200).body(clienteService.buscarClientePeloId(id).get());
		
	}
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarCliente(@Valid @RequestBody Cliente novoCliente) {
		Optional<Object> objetoCadastrado = clienteService.salvarCliente(novoCliente);

		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build();
		}

	}
	
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
