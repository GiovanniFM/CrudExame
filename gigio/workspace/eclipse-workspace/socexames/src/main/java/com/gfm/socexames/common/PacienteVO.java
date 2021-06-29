package com.gfm.socexames.common;

import java.util.Objects;


public class PacienteVO {
	
	private Integer idPaciente;
	private String nmpaciente;	
	
	public PacienteVO() {
		super();
	}
	
    public PacienteVO(Integer idpaciente, String nomePaciente) {
        super();
        this.idPaciente = idpaciente;
        this.nmpaciente = nomePaciente;  
    }	    
    
	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idFuncionario) {
		this.idPaciente = idFuncionario;
	}    
    
	public String getNmPaciente() {
		return nmpaciente;
	}
	public void setNmPaciente(String nomePaciente) {
		this.nmpaciente = nomePaciente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPaciente, nmpaciente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacienteVO other = (PacienteVO) obj;
		return Objects.equals(idPaciente, other.idPaciente) && Objects.equals(nmpaciente, other.nmpaciente);
	}

	@Override
	public String toString() {
		return "PacienteVO [idPaciente=" + idPaciente + ", idPaciente=" + nmpaciente + "]";
	}
	
	

}
