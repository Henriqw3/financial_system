package model;

import java.util.Date;

public class Gerente extends Funcionarios {

	private Date dataIngresso;
	private boolean formacao;

	public Gerente(String nome, String cpf, Date dataNascimento, Character sexo, String rg, String estadoCivil,
			Agencia agencia, Endereco endereco, String ctps, String cargoEmpresa, Double salario, Date dataIngresso,
			boolean formacao) {
		super(nome, cpf, dataNascimento, sexo, rg, estadoCivil, agencia, endereco, ctps, cargoEmpresa, salario);
		setDataIngresso(dataIngresso);
		setFormacao(formacao);
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
