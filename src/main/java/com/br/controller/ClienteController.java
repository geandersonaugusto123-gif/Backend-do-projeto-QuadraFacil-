package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.model.Cliente;
import com.br.service.ClienteService;

import java.util.List;

// Controller responsável por expor os endpoints da entidade Cliente
// Aqui é a camada que recebe as requisições HTTP
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    // Injeção do service, que contém as regras de negócio
    @Autowired
    private ClienteService service;

    // Lista todos os clientes cadastrados
    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    // Busca um cliente específico pelo ID
    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Insere um novo cliente no sistema
    // Os dados vêm no corpo da requisição (JSON)
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    // Atualiza um cliente existente com base no ID
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return service.atualizar(id, cliente);
    }

    // Remove um cliente do sistema pelo ID
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}