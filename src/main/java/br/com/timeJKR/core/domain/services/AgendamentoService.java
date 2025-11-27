package br.com.timeJKR.core.domain.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timeJKR.core.domain.dtos.in.AtualizarAgendamentoPorIdRequest;
import br.com.timeJKR.core.domain.dtos.in.CriarAgendamentoPorMeioDeEntradaESaidaRequest;
import br.com.timeJKR.core.domain.dtos.out.AtualizarAgendamentoPorIdResponse;
import br.com.timeJKR.core.domain.dtos.out.ConsultarDataAgendamentoPorIdResponse;
import br.com.timeJKR.core.domain.dtos.out.CriarAgendamentoPorMeioDeEntradaESaidaResponse;
import br.com.timeJKR.core.domain.dtos.out.DeletarAgendamentoPorIdResponse;
import br.com.timeJKR.core.domain.entities.Agendamento;
import br.com.timeJKR.infrastructure.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired AgendamentoRepository agendamentoRepository;
	
	public ConsultarDataAgendamentoPorIdResponse get(UUID id) {
		
		var agenda = agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException());

		
	
		return new ConsultarDataAgendamentoPorIdResponse(
				 agenda.getEntrada(),
				 agenda.getSaida(),
				 agenda.getStatus());
	}
	
	public CriarAgendamentoPorMeioDeEntradaESaidaResponse post(CriarAgendamentoPorMeioDeEntradaESaidaRequest request) {
		
		var agenda = new Agendamento();
		
		agenda.setEntrada(request.entrada());
		agenda.setSaida(request.saida());
		agenda.setStatus(request.status());
		
		agendamentoRepository.save(agenda);
		
		
	 return new CriarAgendamentoPorMeioDeEntradaESaidaResponse(
			 agenda.getEntrada(),
			 agenda.getSaida(),
			 agenda.getStatus()
			 );
		
	}	
	
	public AtualizarAgendamentoPorIdResponse put(UUID id, AtualizarAgendamentoPorIdRequest request) {
		
		
		var agenda = agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException());
		
		agenda.setEntrada(request.entrada());
		agenda.setSaida(request.saida());
		agenda.setStatus(request.status());
		
		agendamentoRepository.save(agenda);
		
		return new AtualizarAgendamentoPorIdResponse(
				 agenda.getEntrada(),
				 agenda.getSaida(),
				 agenda.getStatus()
				 );
		
		
		
		
		
	}
	
	public DeletarAgendamentoPorIdResponse delete(UUID id) {

		var agenda = agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException());
		
		agendamentoRepository.deleteById(id);
		
		return new DeletarAgendamentoPorIdResponse(
				 agenda.getEntrada(),
				 agenda.getSaida(),
				 agenda.getStatus()
				 );
		
	}
	

}
