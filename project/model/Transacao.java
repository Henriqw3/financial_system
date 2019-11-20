package model;

import java.util.Date;

public class Transacao {
	
	private Date data;
	private Double valor;
	private String canal;
	
	public Transacao(Date data, Double valor, String canal) {
		super();
		setCanal(canal);
		setData(data);
		setValor(valor);
	}

	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String getCanal() {
		return canal;
	}
	
	public void setCanal(String canal) {
		this.canal = canal;
	}
	
}
