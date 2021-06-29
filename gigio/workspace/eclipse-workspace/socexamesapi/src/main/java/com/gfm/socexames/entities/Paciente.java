package com.gfm.socexames.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Paciente {
	
	private Integer idPaciente; 
	private String nmpaciente;	
	private List<ExamePaciente> examePaciente = new ArrayList<ExamePaciente>();
	
	public Paciente() {
		super();
	}
	
    public Paciente(Integer idpaciente, String nomePaciente, List<ExamePaciente> examePaciente) {
        super();
        this.idPaciente = idpaciente;
        this.nmpaciente = nomePaciente;  
        this.examePaciente = examePaciente;
    }	    
    
    public Paciente(Integer idpaciente, String nomePaciente) {
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

	public List<ExamePaciente> getExamePacienteVO() {
		return examePaciente;
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
		Paciente other = (Paciente) obj;
		return Objects.equals(idPaciente, other.idPaciente) && Objects.equals(nmpaciente, other.nmpaciente);
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", idPaciente=" + nmpaciente + "]";
	}
	
	

}
