package com.gfm.socexames.repositories;

import com.gfm.socexames.config.Config;

public class EntitiesRepository {

	public static ExamePacienteRepository createExamePacienteDao() {
		return new ExamePacienteRepository(Config.getConnection());		
	}
	
	public static PacienteRepository createPacienteDao() {
		return new PacienteRepository(Config.getConnection());
	}
	
}
