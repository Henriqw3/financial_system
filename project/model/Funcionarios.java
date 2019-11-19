package model;

public class Funcionarios extends Associados {

	private String ctps;
	private String cargoEmpresa;
	private Double salario;

	public Funcionarios(String ctps, String cargoEmpresa, Double salario) {
		
                //super(nome, cpf, dataNascimento, sexo, rg, estadoCivil);
		this.ctps = ctps;
		this.cargoEmpresa = cargoEmpresa;
		this.salario = salario;
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
