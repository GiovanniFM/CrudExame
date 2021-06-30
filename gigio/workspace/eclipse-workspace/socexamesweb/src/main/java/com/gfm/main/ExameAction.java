package com.gfm.main;

import java.util.ArrayList;
import java.util.List;

import com.gfm.main.entities.Paciente;
import com.gfm.main.service.ExameService;

public class ExameAction {

	public String execute() {
		ExameService exame = new ExameService();
		pacientes = exame.listarExame();
		examesRetorno = pacientes.toString();
		System.out.println(examesRetorno);

		return "success";
	}
	
	private List<Paciente> pacientes = new ArrayList<Paciente>();
	private String examesRetorno;
	

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> paciente) {
		this.pacientes = paciente;
	}

	public String getExamesRetorno() {
		return examesRetorno;
	}

	public void setExamesRetorno(String examesRetorno) {
		this.examesRetorno = examesRetorno;
	}

}