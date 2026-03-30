package com.br.model;

import java.math.BigDecimal;
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

// Entidade que representa a quadra disponível para agendamento
// Aqui ficam os dados físicos e financeiros da quadra
@Entity
@Table(name = "quadra")
public class Quadra {

    // Identificador único da quadra
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Número da quadra dentro do estabelecimento (facilita organização)
    @Column(name = "numero_quadra")
    private Integer numeroQuadra;

    // Nome da quadra
    @Column(name = "nome", length = 100)
    private String nome;

    // Tipo de esporte praticado na quadra (futebol, vôlei, etc.)
    @Column(name = "tipo_esporte", length = 50)
    private String tipoEsporte;

    // Valor cobrado por hora
    // BigDecimal é utilizado para evitar problemas de precisão com valores monetários
    @Column(name = "valor_hora", precision = 10, scale = 2)
    private BigDecimal valorHora;

    // Indica se a quadra é coberta ou não
    @Column(name = "coberta")
    private Boolean coberta;

    // Indica se a quadra está disponível para uso no sistema
    @Column(name = "ativa")
    private Boolean ativa;

    // Relacionamento com reservas (uma quadra pode ter várias reservas)
    // O JsonIgnore evita problemas de loop ao retornar os dados em JSON
    @JsonIgnore
    @OneToMany(mappedBy = "quadra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserva> reservas;

    public Quadra() {
    }

    public Long getId() {
        return id;
    }

    // Permite definir o ID manualmente quando necessário
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroQuadra() {
        return numeroQuadra;
    }

    // Define o número da quadra
    public void setNumeroQuadra(Integer numeroQuadra) {
        this.numeroQuadra = numeroQuadra;
    }

    public String getNome() {
        return nome;
    }

    // Define o nome da quadra
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoEsporte() {
        return tipoEsporte;
    }

    // Define o tipo de esporte
    public void setTipoEsporte(String tipoEsporte) {
        this.tipoEsporte = tipoEsporte;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    // Define o valor por hora da quadra
    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public Boolean getCoberta() {
        return coberta;
    }

    // Define se a quadra é coberta
    public void setCoberta(Boolean coberta) {
        this.coberta = coberta;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    // Define se a quadra está ativa
    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    // Define as reservas associadas à quadra
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}