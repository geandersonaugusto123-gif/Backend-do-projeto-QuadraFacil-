package com.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.exception.BusinessException;
import com.br.exception.ResourceNotFoundException;
import com.br.model.Reserva;
import com.br.repository.ReservaRepository;

import java.util.List;

// Camada de serviço da Reserva
// Aqui fica a principal regra de negócio do sistema: evitar conflitos de horário
@Service
public class ReservaService {

    // Repositório responsável pelo acesso aos dados
    @Autowired
    private ReservaRepository repository;

    // Lista todas as reservas cadastradas
    public List<Reserva> listar() {
        return repository.findAll();
    }

    // Busca uma reserva pelo ID
    // Caso não exista, retorna uma exceção tratada
    public Reserva buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrada com ID: " + id));
    }

    // Salva uma nova reserva com validação de conflito de horário
    public Reserva salvar(Reserva reserva) {

        // Verifica se já existe alguma reserva na mesma quadra, data e faixa de horário
        List<Reserva> conflitos = repository.verificarConflito(
                reserva.getQuadra().getId(),
                reserva.getDataReserva(),
                reserva.getHorarioInicio(),
                reserva.getHorarioFim()
        );

        // Caso exista conflito, impede o cadastro
        if (!conflitos.isEmpty()) {
            throw new BusinessException("Já existe uma reserva nesse horário para essa quadra");
        }

        // Se não houver conflito, a reserva é salva normalmente
        return repository.save(reserva);
    }

    // Atualiza uma reserva existente, também validando conflito de horário
    public Reserva atualizar(Long id, Reserva reserva) {

        // Garante que a reserva realmente existe antes de atualizar
        Reserva existente = buscarPorId(id);

        // Busca possíveis conflitos no novo horário informado
        List<Reserva> conflitos = repository.verificarConflito(
                reserva.getQuadra().getId(),
                reserva.getDataReserva(),
                reserva.getHorarioInicio(),
                reserva.getHorarioFim()
        );

        // Remove da lista a própria reserva (evita conflito com ela mesma)
        conflitos.removeIf(r -> r.getId().equals(id));

        // Se ainda houver conflitos, bloqueia a atualização
        if (!conflitos.isEmpty()) {
            throw new BusinessException("Conflito de horário na atualização");
        }

        // Mantém o ID correto para garantir que será uma atualização
        reserva.setId(id);

        // Salva as alterações
        return repository.save(reserva);
    }

    // Exclui uma reserva pelo ID
    public void excluir(Long id) {
        buscarPorId(id); // valida existência antes de excluir
        repository.deleteById(id);
    }
}