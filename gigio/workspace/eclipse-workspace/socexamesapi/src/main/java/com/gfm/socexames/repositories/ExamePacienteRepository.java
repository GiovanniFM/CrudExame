package com.gfm.socexames.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gfm.socexames.config.Config;
import com.gfm.socexames.dao.ExamePacienteDao;
import com.gfm.socexames.entities.ExamePaciente;
import com.gfm.socexames.entities.Paciente;
import com.gfm.socexames.exceptions.DbException;

public class ExamePacienteRepository implements ExamePacienteDao {

	private Connection conn;
	
	public ExamePacienteRepository(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void insert(Integer idPaciente, List<ExamePaciente> examePaciente) {
		PreparedStatement st = null;
		try {			
			conn.setAutoCommit(false);
			st = conn.prepareStatement("insert into examepaciente "
										+ "(idpaciente, nmexame, dtexame, observacaoexame, resultadoexame) "
										+ " values "
										+ "(?, ?, ?, ?, ?);");
			for (ExamePaciente exame : examePaciente) {
				st.setInt(1, idPaciente);
				st.setString(2, exame.getNomeExame());
				st.setDate(3, new java.sql.Date(exame.getDataExame().getTime()));
				st.setString(4, exame.getObservacao());
				st.setString(5, exame.getResultadoExame());
				st.addBatch();
			}
			int[] rowsAffected = st.executeBatch();
			for (int i = 0; i < rowsAffected.length; i++) {
				if (rowsAffected[i] == 0) {
					conn.rollback();
					throw new DbException("Falha na inserção dos exames");
				}
			}
			conn.commit();		
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			Config.closeStatement(st);
		}	
	}

	@Override
	public ExamePaciente update(ExamePaciente examePaciente) {
		PreparedStatement st = null;
		try {			
			st = conn.prepareStatement("update examepaciente "
										+ "set "+
										" nmexame = ?, "+
										" dtexame = ?, "+
										" observacaoexame = ?, "+
										" resultadoexame = ? "+
										" where idexamepaciente = ? ");		
			st.setString(1, examePaciente.getNomeExame());
			st.setDate(2, new java.sql.Date(examePaciente.getDataExame().getTime()));
			st.setString(3, examePaciente.getObservacao());
			st.setString(4, examePaciente.getResultadoExame());
			st.setInt(5, examePaciente.getIdexamepaciente());			
			st.executeUpdate();
			return examePaciente;	
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			Config.closeStatement(st);
		}		
	}

	@Override
	public void deletebyId(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(" delete from examepaciente where idexamepaciente = ? ");		
			st.setInt(1, id);			
			if(st.executeUpdate() == 0){
				throw new DbException("Nenhum registro deletado.");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			Config.closeStatement(st);
		}		
	}

	@Override
	public ExamePaciente findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
			  " select exames.* " +
			  " from examepaciente exames "+
			  " where exames.idexamepaciente =  ?");
			st.setInt(1, id);
			rs = st.executeQuery();		
			if(rs.next()) {				
				ExamePaciente exames = instantiateExamePaciente(rs);				
				return exames;
			}
			return null;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}		
		finally {
			Config.closeStatement(st);
			Config.closeResultSet(rs);			
		}
	
	}

	private ExamePaciente instantiateExamePaciente(ResultSet rs) throws SQLException {
		
		return new ExamePaciente(
				rs.getInt("idexamepaciente"), 
				rs.getString("nmexame"),
				rs.getDate("dtexame"), 
				rs.getString("observacaoexame"), 
				rs.getString("resultadoexame"));
	}


	private Paciente instantiatePaciente(ResultSet rs) throws SQLException {
		return new Paciente(
				rs.getInt("idpaciente"), 
				rs.getString("nmpaciente"));	
	}


	@Override
	public List<Paciente> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					  " select pacientes.nmpaciente, exames.* "+ 
					  " from examepaciente exames "+
					  " inner join paciente pacientes "+
					  " on exames.idpaciente = pacientes.idpaciente "+
					  " order by nmpaciente, nmexame");
			rs = st.executeQuery();		
			
			List<Paciente> lstPaciente = new ArrayList<>();					
			
			Paciente rsPaciente = null;
			while(rs.next()) {
				
				Integer idPaciente = rs.getInt("idpaciente");		
				
				if (rsPaciente == null) {
					rsPaciente = instantiatePaciente(rs);
				}
					
				if (!rsPaciente.getIdPaciente().equals(idPaciente)) {
					if (rsPaciente != null) {
						lstPaciente.add(rsPaciente);
					}
					rsPaciente = instantiatePaciente(rs);
				}				
				rsPaciente.getExamePacienteVO().add(instantiateExamePaciente(rs));				
			}
			lstPaciente.add(rsPaciente);
			return lstPaciente;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		}
		catch (Exception e) {
			throw new DbException(e.getMessage());
		}
		finally {
			Config.closeStatement(st);
			Config.closeResultSet(rs);			
		}
	}


	@Override
	public Paciente findByPaciente(Integer idPaciente) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					  " select pacientes.nmpaciente, exames.* "+ 
					  " from examepaciente exames "+
					  " inner join paciente pacientes "+
					  " on exames.idpaciente = pacientes.idpaciente "+
					  " where pacientes.idpaciente =  ?"+
					  " order by nmpaciente, nmexame");
			st.setInt(1, idPaciente);
			rs = st.executeQuery();		
			
			Paciente rsPaciente = null;
			while(rs.next()) {
				if (rsPaciente == null) {
					rsPaciente = instantiatePaciente(rs);
				}
				ExamePaciente exames = instantiateExamePaciente(rs);
				rsPaciente.getExamePacienteVO().add(exames);
			}
			return rsPaciente;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}		
		finally {
			Config.closeStatement(st);
			Config.closeResultSet(rs);			
		}
	}

}
