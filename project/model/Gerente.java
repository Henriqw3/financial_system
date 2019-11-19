package model;

import java.util.Date;

public class Gerente {

	 private Date dataIngresso;
	 private boolean formacao;
	
	public Gerente(Date dataIngresso, boolean formacao) {
		super();
		this.dataIngresso = dataIngresso;
		this.formacao = formacao;
	}
	protected Date getDataIngresso() {
		return dataIngresso;
	}
	protected void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}
	protected boolean isFormacao() {
		return formacao;
	}
	protected void setFormacao(boolean formacao) {
		this.formacao = formacao;
	}
}
