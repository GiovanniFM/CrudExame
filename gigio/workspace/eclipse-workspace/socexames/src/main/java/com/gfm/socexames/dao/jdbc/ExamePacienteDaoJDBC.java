package com.gfm.socexames.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gfm.socexames.common.ExamePacienteVO;
import com.gfm.socexames.common.PacienteVO;
import com.gfm.socexames.dao.ExamePacienteDao;
import com.gfm.socexames.db.Config;
import com.gfm.socexames.db.DbException;

public class ExamePacienteDaoJDBC implements ExamePacienteDao {

	private Connection conn;
	
	public ExamePacienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void insert(ExamePacienteVO examePacienteVO) {
		PreparedStatement st = null;
		try {			
			
			st = conn.prepareStatement("insert into examepaciente "
										+ "(idpaciente, nmexame, dtexame, observacaoexame, resultadoexame) "
										+ " values "
										+ "(?, ?, ?, ?, ?);",
										Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, examePacienteVO.getPaciente().getIdPaciente());
			st.setString(2, examePacienteVO.getNomeExame());
			st.setDate(3, new java.sql.Date(examePacienteVO.getDataExame().getTime()));
			st.setString(4, examePacienteVO.getObservacao());
			st.setString(5, examePacienteVO.getResultadoExame());
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					examePacienteVO.setIdexamepaciente(rs.getInt(1));
				}
				Config.closeResultSet(rs);
			}else {
				throw new DbException("A inserção do exame falhou!");
			}				
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			Config.closeStatement(st);
		}	
	}

	@Override
	public void update(ExamePacienteVO examePacienteVO) {
		PreparedStatement st = null;
		try {			
			st = conn.prepareStatement("update examepaciente "
										+ "set "+
										" nmexame = ?, "+
										" dtexame = ?, "+
										" observacaoexame = ?, "+
										" resultadoexame = ? "+
										" where idexamepaciente = ? ");		
			st.setString(1, examePacienteVO.getNomeExame());
			st.setDate(2, new java.sql.Date(examePacienteVO.getDataExame().getTime()));
			st.setString(3, examePacienteVO.getObservacao());
			st.setString(4, examePacienteVO.getResultadoExame());
			st.setInt(5, examePacienteVO.getIdexamepaciente());
			
			st.executeUpdate();
		
			
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
	public ExamePacienteVO findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
			  " select pacientes.nmpaciente, exames.* " +
			  " from examepaciente exames "+
			  " inner join paciente pacientes "+
			  " on exames.idpaciente = pacientes.idpaciente "+
			  " where exames.idexamepaciente =  ?");
			st.setInt(1, id);
			rs = st.executeQuery();		
			if(rs.next()) {
				PacienteVO pacienteVO = instantiatePaciente(rs);
				
				ExamePacienteVO exames = instantiateExamePaciente(rs, pacienteVO);
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

	private ExamePacienteVO instantiateExamePaciente(ResultSet rs, PacienteVO pacienteVO) throws SQLException {
		
		return new ExamePacienteVO(
				rs.getInt("idexamepaciente"), 
				rs.getString("nmexame"),
				rs.getDate("dtexame"), 
				rs.getString("observacaoexame"), 
				rs.getString("resultadoexame"), 
				pacienteVO);
	}


	private PacienteVO instantiatePaciente(ResultSet rs) throws SQLException {
		return new PacienteVO(
				rs.getInt("idpaciente"), 
				rs.getString("nmpaciente"));	
	}


	@Override
	public List<ExamePacienteVO> findAll() {
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
			
			List<ExamePacienteVO> lstExamePaciente = new ArrayList<>();
			Map<Integer, PacienteVO> mapPaciente = new HashMap<>();
			while(rs.next()) {
				PacienteVO rsPaciente = mapPaciente.get(rs.getInt("idpaciente"));
				if (rsPaciente == null) {
					rsPaciente = instantiatePaciente(rs);
					mapPaciente.put(rs.getInt("idpaciente"), rsPaciente);
				}
				ExamePacienteVO exames = instantiateExamePaciente(rs, rsPaciente);
				lstExamePaciente.add(exames);
			}
			return lstExamePaciente;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}		
		finally {
			Config.closeStatement(st);
			Config.closeResultSet(rs);			
		}
	}


	@Override
	public List<ExamePacienteVO> findByPaciente(PacienteVO pacienteVO) {
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
			st.setInt(1, pacienteVO.getIdPaciente());
			rs = st.executeQuery();		
			
			List<ExamePacienteVO> lstExamePaciente = new ArrayList<>();
			Map<Integer, PacienteVO> mapPaciente = new HashMap<>();
			while(rs.next()) {
				PacienteVO rsPaciente = mapPaciente.get(rs.getInt("idpaciente"));
				if (rsPaciente == null) {
					rsPaciente = instantiatePaciente(rs);
					mapPaciente.put(rs.getInt("idpaciente"), rsPaciente);
				}
				ExamePacienteVO exames = instantiateExamePaciente(rs, rsPaciente);
				lstExamePaciente.add(exames);
			}
			return lstExamePaciente;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}		
		finally {
			Config.closeStatement(st);
			Config.closeResultSet(rs);			
		}
	}

}
