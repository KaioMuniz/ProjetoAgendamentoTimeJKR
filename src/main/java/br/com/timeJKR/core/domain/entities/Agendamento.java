package br.com.timeJKR.core.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Agendamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	
	@Column(name="entrada", nullable=true)
	private LocalDateTime entrada; //data hora minuto e segundo
	
	@Column(name="saida", nullable=true)
	private LocalDateTime saida;
	
	@Column(name="status")
	private String status;

}
