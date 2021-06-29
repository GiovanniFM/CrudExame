package com.gfm.socexames.services;

import java.util.List;

import com.gfm.socexames.dao.ExamePacienteDao;
import com.gfm.socexames.entities.ExamePaciente;
import com.gfm.socexames.entities.Paciente;
import com.gfm.socexames.repositories.EntitiesRepository;

public class ExamePacienteService {

	private ExamePacienteDao examePacienteDao = null;
	
	public ExamePacienteService() {
		super();
		examePacienteDao = EntitiesRepository.createExamePacienteDao();			
	}


	public List<Paciente> listarExames() {	
		return examePacienteDao.findAll();
	}	
	
	
	public void insertExames(Integer idPaciente, List<ExamePaciente> examePaciente) {
		examePacienteDao.insert(idPaciente, examePaciente);
	}
	
	public Paciente findById(Integer idPaciente) {	
		return examePacienteDao.findByPaciente(idPaciente);
	}	
	
	public void delete(Integer idExamePaciente) {
		examePacienteDao.deletebyId(idExamePaciente);
	}


	public ExamePaciente updateExame(ExamePaciente examePaciente) {
		ExamePaciente uptExame = examePacienteDao.update(examePaciente); 
		
		return uptExame;
		
	}
	
}
