package com.gfm.socexames.dao;

import com.gfm.socexames.dao.jdbc.ExamePacienteDaoJDBC;
import com.gfm.socexames.dao.jdbc.PacienteDaoJDBC;
import com.gfm.socexames.db.Config;

public class DaoFactory {

	public static ExamePacienteDaoJDBC createExamePacienteDao() {
		return new ExamePacienteDaoJDBC(Config.getConnection());		
	}
	
	public static PacienteDaoJDBC createPacienteDao() {
		return new PacienteDaoJDBC(Config.getConnection());
	}
	
}
