package com.gfm.main;

import java.sql.Date;

public class HelloAction {

	  public String execute() {
	    System.out.print("Value of nmCliente is: " + nmCliente);

	    System.out.print("Value of nmExame is: " + nmExame);
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