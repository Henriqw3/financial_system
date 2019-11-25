package model;

import java.util.Arrays;
import java.util.Date;

public class Clientes extends Associados {
	
	private String escolaridade;
	private Conta[] contas = new Conta[3];
	private String senha = "";

	public Clientes(String nome, String cpf, Date dataNascimento, Character sexo, String rg, String estadoCivil,
			Agencia agencia, Endereco endereco, String escolaridade) {
		super(nome, cpf, dataNascimento, sexo, rg, estadoCivil, agencia, endereco);
		setEscolaridade(escolaridade);
	}

	public Clientes() {}

	public Conta[] getContas() {
		return contas;
	}

	public void setContas(Conta[] contas) {
		this.contas = contas;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String verDados() {
		return "Clientes [escolaridade=" + escolaridade + ", contas=" + Arrays.toString(contas) + ", getAgencia()="
				+ getAgencia() + ", getEndereco()=" + getEndereco() + ", getNome()=" + getNome() + ", getCpf()="
				+ getCpf() + ", getDataNascimento()=" + getDataNascimento() + ", getSexo()=" + getSexo() + ", getRg()="
				+ getRg() + ", getEstadoCivil()=" + getEstadoCivil() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
