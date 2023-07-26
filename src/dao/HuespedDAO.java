package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.result.ResultSetFactory;

import model.Huesped;

public class HuespedDAO {
	final private Connection con;
	
	public HuespedDAO(Connection con) {
		this.con = con;
	}

	public void guardarHuesped(Huesped huesped) {
		try {
			final java.sql.PreparedStatement statement = con.prepareStatement(
					"INSERT INTO HUESPEDES(NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA) "
					+ "VALUES (?, ?, ?, ?, ?, ?)", java.sql.Statement.RETURN_GENERATED_KEYS);
			try(statement){
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setDate(3, huesped.getFechaN());
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6, huesped.getReservaId());

				statement.execute();
			
				final ResultSet resultSet = statement.getGeneratedKeys();
				
				try(resultSet){
					while(resultSet.next()) {
						huesped.setId(resultSet.getInt(1));
					}
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}

	public List<Huesped> listar() {//Lista de huespedes
		List<Huesped> huesped = new ArrayList<>();
		try {
			final java.sql.PreparedStatement statement = con.prepareStatement(
					"SELECT ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA"
					+ " FROM HUESPEDES");
			try(statement){
				statement.execute();			
			
				ResultSet resultSet = statement.getResultSet();
				
				try(resultSet){
					while(resultSet.next()) {
						Huesped fila = new Huesped(
								resultSet.getInt("ID"),
								resultSet.getString("NOMBRE"),
								resultSet.getString("APELLIDO"),
								resultSet.getDate("FECHA_NACIMIENTO"),
								resultSet.getString("NACIONALIDAD"),
								resultSet.getString("TELEFONO"),
								resultSet.getInt("ID_RESERVA"));
						huesped.add(fila);
					}
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException();
		}
		return huesped;
	}

	public List<Huesped> listar(String criterio) { //Busqueda por criterio
		List<Huesped> huesped = new ArrayList<>();
		try {
			final java.sql.PreparedStatement statement = con.prepareStatement(
					"SELECT ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA "
					+ "FROM HUESPEDES WHERE APELLIDO = ?");
			try(statement){
				statement.setString(1, criterio);
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				
				try(resultSet){
					while(resultSet.next()) {
						Huesped fila = new Huesped(
								resultSet.getInt("ID"),
								resultSet.getString("NOMBRE"),
								resultSet.getString("APELLIDO"),
								resultSet.getDate("FECHA_NACIMIENTO"),
								resultSet.getString("NACIONALIDAD"),
								resultSet.getString("TELEFONO"),
								resultSet.getInt("ID_RESERVA"));
						huesped.add(fila);				
						}
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException();
		}
		return huesped;
	}

	public void eliminar(Integer idReserva) {
		try {
			final java.sql.PreparedStatement statement = con.prepareStatement(
					"DELETE FROM HUESPEDES WHERE ID_RESERVA = ?");
			try(statement){
				statement.setInt(1, idReserva);
				statement.execute();
			}
		}catch(SQLException e){
			throw new RuntimeException();
		}
	}

	public int actualizar(Huesped huesped) {
		try {
			java.sql.PreparedStatement statement = con.prepareStatement(
					"UPDATE HUESPEDES SET "
					+ " NOMBRE = ?, APELLIDO = ?, "
					+ " NACIONALIDAD = ?, FECHA_NACIMIENTO = ?, "
					+ " TELEFONO = ? WHERE ID = ?");
			statement.setString(1, huesped.getNombre());
			statement.setString(2, huesped.getApellido());
			statement.setString(3, huesped.getNacionalidad());
			statement.setDate(4, huesped.getFechaN());
			statement.setString(5, huesped.getTelefono());
			statement.setInt(6, huesped.getId());

			statement.execute();
			
			int updateCount = statement.getUpdateCount();
			
			return updateCount;
		}catch(SQLException e) {
			throw new RuntimeException();
		}
		
	}
}
