package model;

import java.util.Date;

public class Funcionarios extends Associados {
	
	private String ctps;
	private String cargoEmpresa;
	private Double salario;
	
        public Funcionarios(){//alternativo
            super();
        }
	
	public Funcionarios(String nome, String cpf, Date dataNascimento, Character sexo, String rg, String estadoCivil,
			Agencia agencia, Endereco endereco, String ctps, String cargoEmpresa, Double salario) {
		super(nome, cpf, dataNascimento, sexo, rg, estadoCivil, agencia, endereco);
		setCtps(ctps);
		setCargoEmpresa(cargoEmpresa);
		setSalario(salario);
	}

	public String getCtps() {
		return ctps;
	}
	
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	
	public String getCargoEmpresa() {
		return cargoEmpresa;
	}
	
	public void setCargoEmpresa(String cargoEmpresa) {
		this.cargoEmpresa = cargoEmpresa;
	}
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
}
