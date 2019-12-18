package com.crisgon.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Evento {

	private String lugar;
	private Date fecha;
	private int aforo;
	private Tipo tipo;
	private String url;
	private byte[] codigoQR;

	public Evento(String lugar, String fecha, int aforo, Tipo tipo, String url, byte[] codigoQR) {
		super();
		this.lugar = lugar;
		try {
			SimpleDateFormat input = new SimpleDateFormat("dd/MM/yyyy");
			Date dateValue = input.parse(fecha);
			this.fecha = dateValue;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.aforo = aforo;
		this.tipo = tipo;
		this.url = url;
		this.codigoQR = codigoQR;
	}

	public String getLugar() {
		return lugar;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getAforo() {
		return aforo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public String getUrl() {
		return url;
	}

	public byte[] getCodigoQR() {
		return codigoQR;
	}

	@Override
	public String toString() {
		return "Evento [lugar=" + lugar + ", fecha=" + fecha + ", aforo=" + aforo + ", tipo=" + tipo + ", url=" + url
				+ ", codigoQR=" + Arrays.toString(codigoQR) + "]";
	}

}
