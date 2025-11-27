package br.com.timeJKR.core.domain.dtos.in;

import java.time.LocalDateTime;

public record AtualizarAgendamentoPorIdRequest(
		LocalDateTime entrada,
		LocalDateTime saida,
		String status
		) {

}
