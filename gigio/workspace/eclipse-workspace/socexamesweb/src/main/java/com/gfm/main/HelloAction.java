package com.gfm.main;

import java.util.ArrayList;
import java.util.List;

import com.gfm.main.entities.Paciente;
import com.gfm.main.service.ExameService;

public class HelloAction {

	public String execute() {
		ExameService exame = new ExameService();
		pacientes = exame.listarExame();
		System.out.println(pacientes.toString());

		return "success";
	}
	
	private List<Paciente> pacientes = new ArrayList<Paciente>();;
	

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> paciente) {
		this.pacientes = paciente;
	}

}