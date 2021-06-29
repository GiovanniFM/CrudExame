package com.gfm.socexames.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gfm.socexames.config.Config;
import com.gfm.socexames.dao.PacienteDao;
import com.gfm.socexames.entities.Paciente;
import com.gfm.socexames.exceptions.DbException;

public class PacienteRepository implements PacienteDao {
	
	private Connection conn;
	
	public PacienteRepository(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public Paciente insert(Paciente paciente) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("insert into paciente "
										+ "(nmpaciente) "
										+ " values "
										+ "(?);",
										Statement.RETURN_GENERATED_KEYS);
			st.setString(1, paciente.getNmPaciente());
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					paciente.setIdPaciente(rs.getInt(1));
				}
				Config.closeResultSet(rs);
			}else {
				throw new DbException("A inserção do paciente falhou!");
			}				
			return paciente;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			Config.closeStatement(st);
		}	
		
	}

	@Override
	public void update(Paciente paciente) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE paciente " +
				"SET nmpaciente = ? " +
				"WHERE idPaciente = ?");

			st.setString(1, paciente.getNmPaciente());
			st.setInt(2, paciente.getIdPaciente());

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
	public Paciente findById(Integer idPaciente) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT nmpaciente FROM paciente WHERE idPaciente = ?");
			st.setInt(1, idPaciente);
			rs = st.executeQuery();
			if (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setIdPaciente(idPaciente);
				paciente.setNmPaciente(rs.getString("nmpaciente"));
				return paciente;
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
	public List<Paciente> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					  " select * "+ 
					  " from paciente exames "+
					  " order by nmpaciente");
			rs = st.executeQuery();		
			
			List<Paciente>  lstPaciente = new ArrayList<>();
			while(rs.next()) {	
				Paciente exames = instantiatePaciente(rs);
				lstPaciente.add(exames);
			}
			return lstPaciente;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}		
		finally {
			Config.closeStatement(st);
			Config.closeResultSet(rs);			
		}
	}
	
	private Paciente instantiatePaciente(ResultSet rs) throws SQLException {
		return new Paciente(
				rs.getInt("idpaciente"), 
				rs.getString("nmpaciente"));	
	}	
	

}
