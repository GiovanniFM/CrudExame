package com.gfm.main.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gfm.main.entities.Paciente;

import reactor.core.publisher.Mono;

@Service
public class ExameService {
	private WebClient webClient = loadWebclient();
	
	private WebClient loadWebclient() {
		
		webClient = WebClient.builder()
				.baseUrl("http://localhost:8090/exames/")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
		
		return webClient;		
	}
	
	public ExameService() {		
		super();
	}

	public List<Paciente> listarExame(){
		Mono<List<Paciente>> monoResponse =  webClient.get()
				.uri("/listar")
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<Paciente>>() {});
		List<Paciente> pacientes = monoResponse.block();

		return pacientes;		
		
	}
	
}
