package model;

import java.sql.Date;

public class Reserva {

	private Integer id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private float valor;
	private String pago;
	
	public Reserva(Date fechaE, Date fechaS, String valorS, String pago) {
		float valor = Float.parseFloat(valorS);//Casteamos el String a entero para poderlo guardar en la base de datos
		this.fechaEntrada = fechaE;
		this.fechaSalida = fechaS;
		this.valor = valor;
		this.pago = pago;
	}
	
	public Reserva(Integer id, Date fechaE, Date fechaS, String valorS, String formaPago) {
		float valor = Float.parseFloat(valorS);
		this.id = id;
		this.fechaEntrada = fechaE;
		this.fechaSalida = fechaS;
		this.valor = valor;
		this.pago = formaPago;
	}

	public int getId() {
		return this.id;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public float getValor() {
		return valor;
	}

	public String getPago() {
		return pago;
	}

	public void setId(int id) {
		this.id = id;
	}
}
