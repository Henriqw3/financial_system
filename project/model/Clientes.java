package model;

import java.util.Date;

public class Clientes extends Associados 
{
	private String escolaridade;
		
	public Clientes(String nome, String cpf, Date dataNascimento, Character sexo, String rg, String estadoCivil, 
			String escolaridade){
		
		//super(nome, cpf, dataNascimento, sexo, rg, estadoCivil);
		this.escolaridade = escolaridade;
	}
	protected String getEscolaridade() 
	{
		return escolaridade;
	}
	protected void setEscolaridade(String escolaridade) 
	{
		this.escolaridade = escolaridade;
	}
	
}
