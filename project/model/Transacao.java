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

	protected Date getData() {
		return data;
	}
	
	protected void setData(Date data) {
		this.data = data;
	}
	
	protected Double getValor() {
		return valor;
	}
	
	protected void setValor(Double valor) {
		this.valor = valor;
	}
	
	protected String getCanal() {
		return canal;
	}
	
	protected void setCanal(String canal) {
		this.canal = canal;
	}
	
}
