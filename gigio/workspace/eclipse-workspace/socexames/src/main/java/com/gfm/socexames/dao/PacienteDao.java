package com.gfm.socexames.dao;

import java.util.List;

import com.gfm.socexames.common.PacienteVO;

public interface PacienteDao {

	void insert(PacienteVO pacienteVO);
	void update(PacienteVO pacienteVO);
	void deletebyId(Integer idPaciente);
	PacienteVO findById(Integer idPaciente);
	List<PacienteVO> findAll();
}
