package br.com.timeJKR.infrastructure.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.timeJKR.core.domain.dtos.in.AtualizarAgendamentoPorIdRequest;
import br.com.timeJKR.core.domain.dtos.in.CriarAgendamentoPorMeioDeEntradaESaidaRequest;
import br.com.timeJKR.core.domain.dtos.out.AtualizarAgendamentoPorIdResponse;
import br.com.timeJKR.core.domain.dtos.out.ConsultarDataAgendamentoPorIdResponse;
import br.com.timeJKR.core.domain.dtos.out.CriarAgendamentoPorMeioDeEntradaESaidaResponse;
import br.com.timeJKR.core.domain.dtos.out.DeletarAgendamentoPorIdResponse;
import br.com.timeJKR.core.domain.services.AgendamentoService;

@RequestMapping("/api/v1/agenda")
@RestController
public class AgendamentoController {
	
	@Autowired AgendamentoService agendamentoService;
	
	@PostMapping
	public ResponseEntity<CriarAgendamentoPorMeioDeEntradaESaidaResponse> criarAgendamentoPorMeioDeEntradaESaida(@RequestBody CriarAgendamentoPorMeioDeEntradaESaidaRequest request) {
		
		return ResponseEntity.ok(agendamentoService.post(request));
		
		
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<ConsultarDataAgendamentoPorIdResponse> consultarDataAgendamentoPorId(@RequestParam UUID id) {
	
		return ResponseEntity.ok(agendamentoService.get(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AtualizarAgendamentoPorIdResponse> atualizarAgendamentoPorId(@RequestParam UUID id, @RequestBody AtualizarAgendamentoPorIdRequest request) {
		
		return ResponseEntity.ok(agendamentoService.put(id, request));
	}
	
	@DeleteMapping
	public ResponseEntity<DeletarAgendamentoPorIdResponse> deletarAgendamentoPorId(@RequestParam UUID id) {
		
		
		return ResponseEntity.ok(agendamentoService.delete(id));
	}
}
