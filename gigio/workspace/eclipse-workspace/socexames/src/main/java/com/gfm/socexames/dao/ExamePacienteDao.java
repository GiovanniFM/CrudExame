package com.gfm.socexames.dao;

import java.util.List;

import com.gfm.socexames.common.ExamePacienteVO;
import com.gfm.socexames.common.PacienteVO;


public interface ExamePacienteDao {

	
	void insert(ExamePacienteVO paciente);
	void update(ExamePacienteVO paciente);
	void deletebyId(Integer id);
	ExamePacienteVO findById(Integer id);
	List<ExamePacienteVO> findAll();
	List<ExamePacienteVO> findByPaciente(PacienteVO pacienteVO);
}
