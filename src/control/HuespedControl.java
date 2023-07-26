package control;

import java.sql.Date;
import java.util.List;

import dao.HuespedDAO;
import factory.ConnectionFactory;
import model.Huesped;

public class HuespedControl {
	private HuespedDAO huespedDAO;
	
	public HuespedControl() {
		ConnectionFactory con = new ConnectionFactory();
		this.huespedDAO = new HuespedDAO(con.recuperaConexion());
	}
	
	public void guardarHuesped(Huesped huesped, Integer idReserva) {
		huesped.setIdReserva(idReserva);
		huespedDAO.guardarHuesped(huesped);
	}

	public List<Huesped> listar() {
		return huespedDAO.listar();
	}

	public List<Huesped> listar(String criterio) {
		return huespedDAO.listar(criterio);
	}

	public void eliminar(Integer idReserva) {
		huespedDAO.eliminar(idReserva);
	}

	public int modificar(int id, String nombre, String apellido, Date fechaN, String nacionalidad,
			String telefono) {
		Huesped huesped = new Huesped(id, nombre, apellido, fechaN, nacionalidad, telefono);
		return huespedDAO.actualizar(huesped);
	}

}
