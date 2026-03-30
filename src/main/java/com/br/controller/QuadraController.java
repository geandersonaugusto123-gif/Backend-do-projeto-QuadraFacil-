package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.model.Quadra;
import com.br.service.QuadraService;

import java.util.List;

// Controller responsável pelos endpoints relacionados às quadras
// Atua como ponto de entrada das requisições HTTP para essa entidade
@RestController
@RequestMapping("/quadras")
public class QuadraController {

    // Service onde ficam as regras de negócio da quadra
    @Autowired
    private QuadraService service;

    // Retorna todas as quadras cadastradas
    @GetMapping
    public List<Quadra> listar() {
        return service.listar();
    }

    // Busca uma quadra específica pelo ID
    @GetMapping("/{id}")
    public Quadra buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Cadastra uma nova quadra
    // Os dados são recebidos via corpo da requisição (JSON)
    @PostMapping
    public Quadra salvar(@RequestBody Quadra quadra) {
        return service.salvar(quadra);
    }

    // Atualiza os dados de uma quadra existente
    @PutMapping("/{id}")
    public Quadra atualizar(@PathVariable Long id, @RequestBody Quadra quadra) {
        return service.atualizar(id, quadra);
    }

    // Remove uma quadra do sistema pelo ID
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}