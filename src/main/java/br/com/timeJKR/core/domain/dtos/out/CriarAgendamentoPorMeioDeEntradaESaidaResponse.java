package br.com.timeJKR.core.domain.dtos.out;

import java.time.LocalDateTime;

public record CriarAgendamentoPorMeioDeEntradaESaidaResponse(
		LocalDateTime entrada,
		LocalDateTime saida,
		String status
		) {

}
