package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reserva;

public class ReservaDAO {
	final private Connection con;
	
	public ReservaDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Reserva nuevaReserva) {
		try {
			final java.sql.PreparedStatement statement = con.prepareStatement(
					"INSERT INTO reservas (fecha_entrada, fecha_salida, valor, forma_pago) "
					+ "VALUES (?,?,?,?)", java.sql.Statement.RETURN_GENERATED_KEYS);
			try(statement) {
				statement.setDate(1, nuevaReserva.getFechaEntrada());
				statement.setDate(2, nuevaReserva.getFechaSalida());
				statement.setFloat(3, nuevaReserva.getValor());
				statement.setString(4, nuevaReserva.getPago());
				statement.executeUpdate();

				final ResultSet resultSet = statement.getGeneratedKeys();
				
				
				try(resultSet){
					while(resultSet.next()) {
						nuevaReserva.setId(resultSet.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
	}

	public List<Reserva> listar() {
		List<Reserva> reservas = new ArrayList<>();
		try {
			java.sql.PreparedStatement statement = con.prepareStatement(
					"SELECT ID, FECHA_ENTRADA, FECHA_SALIDA, VALOR, FORMA_PAGO FROM RESERVAS");
			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			
			try(resultSet){
				while(resultSet.next()) {
					Reserva fila = new Reserva(
							resultSet.getInt("ID"),
							resultSet.getDate("FECHA_ENTRADA"),
							resultSet.getDate("FECHA_SALIDA"),
							resultSet.getInt("VALOR"),
							resultSet.getString("FORMA_PAGO"));
					reservas.add(fila);
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException();
		}
		return reservas;
	}
}
