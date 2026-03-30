package com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.model.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

// Interface responsável pelo acesso aos dados de Reserva
// Além do CRUD padrão, aqui foi criada uma consulta personalizada
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	// Consulta para verificar conflito de horários em uma mesma quadra
	// A ideia é garantir que não existam reservas sobrepostas no mesmo período
	@Query("SELECT r FROM Reserva r " +
		       "WHERE r.quadra.id = :quadraId " +
		       "AND r.dataReserva = :data " +
		       "AND ( " +
		       "(:inicio BETWEEN r.horarioInicio AND r.horarioFim) OR " +
		       "(:fim BETWEEN r.horarioInicio AND r.horarioFim) OR " +
		       "(r.horarioInicio BETWEEN :inicio AND :fim) " +
		       ")")
		List<Reserva> verificarConflito(
		        @Param("quadraId") Long quadraId,
		        @Param("data") LocalDate data,
		        @Param("inicio") LocalTime inicio,
		        @Param("fim") LocalTime fim
		);
	
}