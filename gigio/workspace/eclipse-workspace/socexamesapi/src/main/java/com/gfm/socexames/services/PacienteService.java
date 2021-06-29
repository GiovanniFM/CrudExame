package com.gfm.socexames.services;

import java.util.List;

import com.gfm.socexames.dao.PacienteDao;
import com.gfm.socexames.entities.Paciente;
import com.gfm.socexames.repositories.EntitiesRepository;

public class PacienteService {
	
	
	public List<Paciente> listarPacientes() {
		PacienteDao pacientedao = EntitiesRepository.createPacienteDao();		
		return pacientedao.findAll();
	}
	
	public Paciente findById(Integer idPaciente) {
		PacienteDao pacientedao = EntitiesRepository.createPacienteDao();		
		return pacientedao.findById(idPaciente);
	}	
	
	public Paciente insert(Paciente paciente) {
		PacienteDao pacientedao = EntitiesRepository.createPacienteDao();		
		return pacientedao.insert(paciente);
	}


}
