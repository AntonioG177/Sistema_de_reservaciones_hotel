package dao;

import java.sql.Connection;
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
				//System.out.println(huesped.getNombre());
				//System.out.println(huesped.getApellido());
				//System.out.println(huesped.getFechaN());
				//System.out.println(huesped.getNacionalidad());
				//System.out.println(huesped.getTelefono());
				//System.out.println(huesped.getReservaId());
				statement.execute();
				//System.out.println("Pasa");
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

	public List<Huesped> listar() {
		List<Huesped> huesped = new ArrayList<>();
		try {
			java.sql.PreparedStatement statement = con.prepareStatement(
					"SELECT ID, NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, ID_RESERVA"
					+ " FROM HUESPEDES");
			statement.execute();
			
			ResultSet resulSet = statement.getResultSet();
			
			try(resulSet){
				while(resulSet.next()) {
					Huesped fila = new Huesped(
							resulSet.getInt("ID"),
							resulSet.getString("NOMBRE"),
							resulSet.getString("APELLIDO"),
							resulSet.getDate("FECHA_NACIMIENTO"),
							resulSet.getString("NACIONALIDAD"),
							resulSet.getString("TELEFONO"),
							resulSet.getInt("ID_RESERVA"));
					huesped.add(fila);
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException();
		}
		return huesped;
	}
}
