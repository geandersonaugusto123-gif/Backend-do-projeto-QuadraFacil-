package com.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.model.Quadra;
import com.br.repository.QuadraRepository;
import com.br.exception.ResourceNotFoundException;

import java.util.List;

// Camada de serviço da Quadra
// Responsável por intermediar as regras antes de acessar o banco
@Service
public class QuadraService {

    // Repositório que faz a comunicação com o banco de dados
    @Autowired
    private QuadraRepository repository;

    // Lista todas as quadras cadastradas
    public List<Quadra> listar() {
        return repository.findAll();
    }

    // Busca uma quadra pelo ID
    // Caso não exista, retorna uma exceção controlada
    public Quadra buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quadra não encontrada com ID: " + id));
    }

    // Salva uma nova quadra
    public Quadra salvar(Quadra quadra) {
        return repository.save(quadra);
    }

    // Atualiza uma quadra existente
    // Primeiro valida se ela existe, depois mantém o mesmo ID na atualização
    public Quadra atualizar(Long id, Quadra quadra) {
        buscarPorId(id);
        quadra.setId(id);
        return repository.save(quadra);
    }

    // Exclui uma quadra
    // Também valida antes para evitar inconsistências
    public void excluir(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}