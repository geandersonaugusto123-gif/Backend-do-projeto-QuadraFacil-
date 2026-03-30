package com.br.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Entidade que representa o cliente no sistema
// Cada cliente pode possuir uma ou mais reservas
@Entity
@Table(name = "cliente")
public class Cliente {

    // Identificador único do cliente (chave primária)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do cliente
    @Column(name = "nome", length = 100)
    private String nome;

    // CPF do cliente
    @Column(name = "cpf", length = 14)
    private String cpf;

    // Telefone para contato
    @Column(name = "telefone", length = 20)
    private String telefone;

    // Email do cliente
    @Column(name = "email", length = 100)
    private String email;

    // Indica se o cliente está ativo no sistema
    @Column(name = "ativo")
    private Boolean ativo;

    // Relacionamento com reservas (um cliente pode ter várias reservas)
    // O JsonIgnore evita problemas de loop na hora de retornar os dados em JSON
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserva> reservas;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    // Permite definir o ID manualmente quando necessário (ex: atualização)
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    // Define o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    // Define o CPF
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    // Define o telefone
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    // Define o email
    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    // Define se o cliente está ativo ou não
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    // Define a lista de reservas associadas ao cliente
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}