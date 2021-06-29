package com.gfm.socexames.dao;

import java.util.List;

import com.gfm.socexames.entities.ExamePaciente;
import com.gfm.socexames.entities.Paciente;


public interface ExamePacienteDao {

	
	void insert(Integer idPaciente, List<ExamePaciente> examePaciente);
	ExamePaciente update(ExamePaciente paciente);
	void deletebyId(Integer id);
	ExamePaciente findById(Integer id);
	List<Paciente> findAll();
	Paciente findByPaciente(Integer idPaciente);
}
