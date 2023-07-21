package control;

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

}
