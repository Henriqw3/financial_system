package model;

import java.util.Date;

public class Funcionarios extends Associados {
	
	private String ctps;
	private String cargoEmpresa;
	private Double salario;
	
	
	
	public Funcionarios(String nome, String cpf, Date dataNascimento, Character sexo, String rg, String estadoCivil,
			Agencia agencia, Endereco endereco, String ctps, String cargoEmpresa, Double salario) {
		super(nome, cpf, dataNascimento, sexo, rg, estadoCivil, agencia, endereco);
		setCtps(ctps);
		setCargoEmpresa(cargoEmpresa);
		setSalario(salario);
	}

	protected String getCtps() {
		return ctps;
	}
	
	protected void setCtps(String ctps) {
		this.ctps = ctps;
	}
	
	protected String getCargoEmpresa() {
		return cargoEmpresa;
	}
	
	protected void setCargoEmpresa(String cargoEmpresa) {
		this.cargoEmpresa = cargoEmpresa;
	}
	
	protected Double getSalario() {
		return salario;
	}
	
	protected void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
}
