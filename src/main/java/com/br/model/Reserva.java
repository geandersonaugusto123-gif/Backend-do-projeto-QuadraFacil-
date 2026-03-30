package com.br.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

// Entidade que representa a reserva de uma quadra
// Aqui acontece o vínculo entre cliente, quadra e horário
@Entity
@Table(name = "reserva")
public class Reserva {

    // Identificador único da reserva
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Data em que a reserva será realizada
    private LocalDate dataReserva;

    // Horário de início da reserva
    private LocalTime horarioInicio;

    // Horário de término da reserva
    private LocalTime horarioFim;

    // Valor total da reserva (calculado com base no tempo e valor da quadra)
    private Double valorTotal;

    // Status da reserva (ex: CONFIRMADA, CANCELADA, PENDENTE)
    private String status;

    // Campo livre para observações adicionais
    private String observacao;

    // Relacionamento com cliente (muitas reservas podem pertencer a um cliente)
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Relacionamento com quadra (muitas reservas podem ser feitas para uma mesma quadra)
    @ManyToOne
    @JoinColumn(name = "quadra_id")
    private Quadra quadra;

    public Reserva() {
    }

    public Long getId() {
        return id;
    }

    // Permite definir o ID em operações como atualização
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    // Define a data da reserva
    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    // Define o horário de início
    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    // Define o horário de término
    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    // Define o valor total da reserva
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    // Define o status atual da reserva
    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    // Define observações adicionais
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Associa a reserva a um cliente
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quadra getQuadra() {
        return quadra;
    }

    // Associa a reserva a uma quadra
    public void setQuadra(Quadra quadra) {
        this.quadra = quadra;
    }
}