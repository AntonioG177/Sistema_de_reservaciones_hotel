package model;

import java.sql.Date;

public class Reserva {

	private Integer id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private int valor;
	private String pago;
	
	public Reserva(Date fechaE, Date fechaS, String valorS, String pago) {
		int valor = Integer.parseInt(valorS);//Casteamos el String a entero para poderlo guardar en la base de datos
		this.fechaEntrada = fechaE;
		this.fechaSalida = fechaS;
		this.valor = valor;
		this.pago = pago;
	}
	
	public Reserva(Integer id, Date fechaE, Date fechaS, String valorS, String formaPago) {
		int valor = Integer.parseInt(valorS);
		this.id = id;
		this.fechaEntrada = fechaE;
		this.fechaSalida = fechaS;
		this.valor = valor;
		this.pago = formaPago;
	}

	public Reserva(int id, Date fechaE, Date fechaS, int valor, String formaPago) {
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
