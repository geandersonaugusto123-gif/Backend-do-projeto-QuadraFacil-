package com.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.model.Cliente;
import com.br.repository.ClienteRepository;
import com.br.exception.ResourceNotFoundException;

import java.util.List;

// Camada de serviço do Cliente
// Aqui ficam as regras de negócio antes de acessar o banco
@Service
public class ClienteService {

    // Repositório responsável pela persistência dos dados
    @Autowired
    private ClienteRepository repository;

    // Retorna todos os clientes cadastrados
    public List<Cliente> listar() {
        return repository.findAll();
    }

    // Busca um cliente pelo ID
    // Caso não encontre, lança uma exceção controlada
    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + id));
    }

    // Salva um novo cliente no banco
    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    // Atualiza um cliente existente
    // Primeiro verifica se o registro existe, depois salva com o mesmo ID
    public Cliente atualizar(Long id, Cliente cliente) {
        buscarPorId(id); // garante que o cliente existe antes de atualizar
        cliente.setId(id);
        return repository.save(cliente);
    }

    // Exclui um cliente pelo ID
    // Também valida a existência antes de remover
    public void excluir(Long id) {
        buscarPorId(id); // evita tentar excluir algo que não existe
        repository.deleteById(id);
    }
}