package com.gfm.socexames.dao;

import java.util.List;

import com.gfm.socexames.entities.Paciente;

public interface PacienteDao {

	Paciente insert(Paciente paciente);
	void update(Paciente paciente);
	void deletebyId(Integer idPaciente);
	Paciente findById(Integer idPaciente);
	List<Paciente> findAll();
}
