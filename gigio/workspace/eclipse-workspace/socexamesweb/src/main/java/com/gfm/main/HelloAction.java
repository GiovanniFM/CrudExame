package com.gfm.main;

import java.sql.Date;
import java.util.List;

import com.gfm.main.entities.Paciente;
import com.gfm.main.service.ExameService;

public class HelloAction {

	public String execute() {
		ExameService exame = new ExameService();
		List<Paciente> paciente = exame.listarExame();
		System.out.println(paciente.toString());

		System.out.println("Value of nmCliente is: " + nmCliente);

		System.out.println("Value of nmExame is: " + nmExame);

		System.out.println("Value of observação is: " + observacaoExame);

		return "success";
	}

	private String nmCliente;
	private String nmExame;
	private Date dtExame;
	private String observacaoExame;
	private String resultadoExame;

	public String getNmCliente() {
		return nmCliente;
	}

	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}

	public String getNmExame() {
		return nmExame;
	}

	public void setNmExame(String nmExame) {
		this.nmExame = nmExame;
	}

	public Date getDtExame() {
		return dtExame;
	}

	public void setDtExame(Date dtExame) {
		this.dtExame = dtExame;
	}

	public String getObservacaoExame() {
		return observacaoExame;
	}

	public void setObservacaoExame(String observacaoExame) {
		this.observacaoExame = observacaoExame;
	}

	public String getResultadoExame() {
		return resultadoExame;
	}

	public void setResultadoExame(String resultadoExame) {
		this.resultadoExame = resultadoExame;
	}

}