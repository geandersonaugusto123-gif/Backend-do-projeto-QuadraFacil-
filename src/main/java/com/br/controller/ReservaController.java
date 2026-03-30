package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.model.Reserva;
import com.br.service.ReservaService;

import java.util.List;

// Controller responsável pelos endpoints de reserva
// Aqui são recebidas as requisições relacionadas ao agendamento das quadras
@RestController
@RequestMapping("/reservas")
public class ReservaController {

    // Service que contém as regras de negócio das reservas
    @Autowired
    private ReservaService service;

    // Lista todas as reservas cadastradas
    @GetMapping
    public List<Reserva> listar() {
        return service.listar();
    }

    // Busca uma reserva específica pelo ID
    @GetMapping("/{id}")
    public Reserva buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Cria uma nova reserva
    // Recebe os dados no corpo da requisição (JSON)
    @PostMapping
    public Reserva salvar(@RequestBody Reserva reserva) {
        return service.salvar(reserva);
    }

    // Atualiza uma reserva existente com base no ID
    @PutMapping("/{id}")
    public Reserva atualizar(@PathVariable Long id, @RequestBody Reserva reserva) {
        return service.atualizar(id, reserva);
    }

    // Exclui uma reserva pelo ID
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}