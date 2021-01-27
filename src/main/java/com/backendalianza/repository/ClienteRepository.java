package com.backendalianza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backendalianza.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
