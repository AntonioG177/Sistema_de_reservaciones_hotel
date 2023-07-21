package control;

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

}
