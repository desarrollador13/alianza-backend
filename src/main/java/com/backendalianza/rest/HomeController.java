package com.backendalianza.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.backendalianza.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.backendalianza.services.ClienteService;

@RestController
@RequestMapping("api/v1/clientes")
public class HomeController {
	
	@Autowired
	private ClienteService clienteService;
	RestTemplate restTemplate = new RestTemplate();
	final String uri = "https://jsonplaceholder.typicode.com/posts";
	String  result;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	private ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente) {
		System.out.println(cliente);
		Cliente temporal =  clienteService.crear(cliente);
		try {
			return ResponseEntity.created(new URI("/api/v1/clientes"+ temporal.getId())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	private ResponseEntity<List<Cliente>> listar() {
		return ResponseEntity.ok(clienteService.obtenerCliente());
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value= "{id}")
	private ResponseEntity<Optional<Cliente>> listar(@PathVariable ("id") Integer id) {
		return ResponseEntity.ok(clienteService.obtenerId(id));
	}
	
	/*@GetMapping
	public ResponseEntity<Object> getService() {
		result = restTemplate.getForObject(uri, String.class);
		System.out.println(result);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}*/

}
