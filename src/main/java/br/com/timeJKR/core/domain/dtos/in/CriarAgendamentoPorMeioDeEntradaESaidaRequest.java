package br.com.timeJKR.core.domain.dtos.in;

import java.time.LocalDateTime;

public record CriarAgendamentoPorMeioDeEntradaESaidaRequest(
		LocalDateTime entrada,
		LocalDateTime saida,
		String status
		) {

}
