package com.backendalianza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendalianza.model.Cliente;
import com.backendalianza.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository; 
	
	public Cliente crear(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> obtenerCliente() {
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> obtenerId(Integer id) {
		return clienteRepository.findById(id);
	}

}
