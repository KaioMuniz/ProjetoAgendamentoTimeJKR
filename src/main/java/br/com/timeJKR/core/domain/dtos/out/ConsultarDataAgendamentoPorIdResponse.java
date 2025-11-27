package br.com.timeJKR.core.domain.dtos.out;

import java.time.LocalDateTime;

public record ConsultarDataAgendamentoPorIdResponse(
		LocalDateTime entrada,
		LocalDateTime saida,
		String status
		) {

}
