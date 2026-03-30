package com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.model.Cliente;

// Interface de acesso aos dados da entidade Cliente
// Ao estender JpaRepository, já herdamos todas as operações básicas de banco (CRUD)
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}