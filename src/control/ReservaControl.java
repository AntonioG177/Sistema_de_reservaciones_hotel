package control;

import java.sql.Date;
import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Reserva;

public class ReservaControl {

	private ReservaDAO reservaDAO;
	
	public ReservaControl() {
		ConnectionFactory factory = new ConnectionFactory();
		this.reservaDAO = new ReservaDAO(factory.recuperaConexion());
	}
	
	public void guardar(Reserva nuevaReserva) {
		reservaDAO.guardar(nuevaReserva);
	}

	public List<Reserva> listar() {
		return reservaDAO.listar();
	}

	public List<Reserva> listar(String criterio) {
		Integer criterioId = Integer.parseInt(criterio);
		return reservaDAO.listar(criterioId);
	}

	public void eliminar(Integer id) {
		reservaDAO.eliminar(id);
	}

	public int actualizar(Integer id, Date fechaE, Date fechaS, String valor, String pago) {
		Reserva reserva = new Reserva(id, fechaE, fechaS, valor, pago);
		return reservaDAO.actualizar(reserva);
	}

}
