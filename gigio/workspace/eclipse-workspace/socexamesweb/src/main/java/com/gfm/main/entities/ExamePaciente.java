package com.gfm.main.entities;

import java.util.Date;
import java.util.Objects;

public class ExamePaciente{

	private Integer idexamepaciente;

	private String nmExame;
	private Date dtExame;
	private String observacao;
	private String resultadoExame;	
	
	public ExamePaciente(Integer idexamepaciente, String nomeExame, Date dataExame, String observacao,
			String resultadoExame) {
		
		this.idexamepaciente= idexamepaciente;
		this.nmExame = nomeExame;
		this.dtExame = dataExame;
		this.observacao = observacao;
		this.resultadoExame = resultadoExame;
	}	
	
	public ExamePaciente() {
		super();
	}

	public String getNmExame() {
		return nmExame;
	}
	public Integer getIdexamepaciente() {
		return idexamepaciente;
	}

	public void setIdexamepaciente(Integer idexamepaciente) {
		this.idexamepaciente = idexamepaciente;
	}

	public void setNmExame(String nomeExame) {
		this.nmExame = nomeExame;
	}
	public Date getDtExame() {
		return dtExame;
	}
	public void setDtExame(Date dataExame) {
		this.dtExame = dataExame;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getResultadoExame() {
		return resultadoExame;
	}
	public void setResultadoExame(String resultadoExame) {
		this.resultadoExame = resultadoExame;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idexamepaciente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamePaciente other = (ExamePaciente) obj;
		return idexamepaciente == other.idexamepaciente;
	}

	@Override
	public String toString() {
		return "ExamePaciente [idexamepaciente=" + idexamepaciente + ", nmExame=" + nmExame + ", dtExame="
				+ dtExame + ", observacao=" + observacao + ", resultadoExame=" + resultadoExame  + "]";
	}	
	
	

}
