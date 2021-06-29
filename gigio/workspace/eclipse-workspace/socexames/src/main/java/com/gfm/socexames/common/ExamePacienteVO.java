package com.gfm.socexames.common;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ExamePacienteVO{

	private Integer idexamepaciente;

	private String nomeExame;
	private Date dataExame;
	private String observacao;
	private String resultadoExame;
	
	private PacienteVO pacienteVO;
	
	
	public ExamePacienteVO(Integer idexamepaciente, String nomeExame, Date dataExame, String observacao,
			String resultadoExame, PacienteVO pacienteVO) {
		
		this.idexamepaciente= idexamepaciente;
		this.nomeExame = nomeExame;
		this.dataExame = dataExame;
		this.observacao = observacao;
		this.resultadoExame = resultadoExame;
		this.pacienteVO = pacienteVO;
	}	
	
	public String getNomeExame() {
		return nomeExame;
	}
	public Integer getIdexamepaciente() {
		return idexamepaciente;
	}

	public void setIdexamepaciente(Integer idexamepaciente) {
		this.idexamepaciente = idexamepaciente;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}
	public Date getDataExame() {
		return dataExame;
	}
	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
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

	public PacienteVO getPaciente() {
		return pacienteVO;
	}

	public void setPaciente(PacienteVO pacienteVO) {
		this.pacienteVO = pacienteVO;
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
		ExamePacienteVO other = (ExamePacienteVO) obj;
		return idexamepaciente == other.idexamepaciente;
	}

	@Override
	public String toString() {
		return "ExamePacienteVO [idexamepaciente=" + idexamepaciente + ", nomeExame=" + nomeExame + ", dataExame="
				+ dataExame + ", observacao=" + observacao + ", resultadoExame=" + resultadoExame + ", pacienteVO="
				+ pacienteVO + "]";
	}	
	
	

}
