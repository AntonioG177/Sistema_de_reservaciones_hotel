package factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private DataSource datasource;
	
	public ConnectionFactory() {
		// Iniciamos un objeto comboPooledDataSource que permitira la conexion multiple
		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
		// Configuramos la jdbc, usuario y contraseña
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/sistema_reservas?useTimeZone=true&serverTimeZone=UTC");//Direccion de la base de datos a la que te conectas
		pooledDataSource.setUser("root");//Usuario de la base de datos a la que te conectas
		pooledDataSource.setPassword("IAntony1585I");// Contraseña de la base de datos a la que te quieres conectar
		// Con el setMaxPoolSize se determina la cantidad maxima de conexiones que se pueden abrir
		pooledDataSource.setMaxPoolSize(10);
		
		this.datasource = pooledDataSource;
	}
	public Connection recuperaConexion() {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
