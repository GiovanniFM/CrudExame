package com.gfm.socexames.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.gfm.socexames.common.PacienteVO;
import com.gfm.socexames.dao.PacienteDao;
import com.gfm.socexames.db.Config;
import com.gfm.socexames.db.DbException;

public class PacienteDaoJDBC implements PacienteDao {
	
	private Connection conn;
	
	public PacienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(PacienteVO pacienteVO) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("insert into paciente "
										+ "(nmpaciente) "
										+ " values "
										+ "(?);",
										Statement.RETURN_GENERATED_KEYS);
			st.setString(1, pacienteVO.getNmPaciente());
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					pacienteVO.setIdPaciente(rs.getInt(1));
				}
				Config.closeResultSet(rs);
			}else {
				throw new DbException("A inserção do paciente falhou!");
			}				
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			Config.closeStatement(st);
		}	
		
	}

	@Override
	public void update(PacienteVO pacienteVO) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE paciente " +
				"SET nmpaciente = ? " +
				"WHERE idPaciente = ?");

			st.setString(1, pacienteVO.getNmPaciente());
			st.setInt(2, pacienteVO.getIdPaciente());

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			Config.closeStatement(st);
		}
		
	}

	@Override
	public void deletebyId(Integer idPaciente) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM paciente where idPaciente = ?");

			st.setInt(1, idPaciente);

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			Config.closeStatement(st);
		}		
	}

	@Override
	public PacienteVO findById(Integer idPaciente) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT nmpaciente FROM paciente WHERE idPaciente = ?");
			st.setInt(1, idPaciente);
			rs = st.executeQuery();
			if (rs.next()) {
				PacienteVO pacienteVO = new PacienteVO();
				pacienteVO.setIdPaciente(idPaciente);
				pacienteVO.setNmPaciente(rs.getString("nmpaciente"));
				return pacienteVO;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			Config.closeStatement(st);
			Config.closeResultSet(rs);
		}
	}

	@Override
	public List<PacienteVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
