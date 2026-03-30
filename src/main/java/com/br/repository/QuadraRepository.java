package com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.model.Quadra;

// Interface responsável pela comunicação com o banco de dados da entidade Quadra
// O JpaRepository já fornece métodos prontos como salvar, buscar, listar e excluir
public interface QuadraRepository extends JpaRepository<Quadra, Long> {

}