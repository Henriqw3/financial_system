package model;

import java.util.Date;

public abstract class Conta {
	
	private String senha;
	private Boolean status = false;
	private String numConta;
	private Date dataAbertura;
	private Date dataUltMov;
	private Double saldo;
	private Agencia agencia;
	private Clientes[] donos = new Clientes[2];
	private Transacao[] transacoes;

	public Conta(String senha, String numConta, Date dataAbertura, Date dataUltMov,
			Agencia agencia, Clientes[] donos) {
		super();
		setAgencia(agencia);
		setDonos(donos);
		setDataAbertura(dataAbertura);
		setDataUltMov(dataUltMov);
		setNumConta(numConta);
		setSaldo(0.0);
		setSenha(senha);
		setStatus(false);
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Clientes[] getDonos() {
		return donos;
	}

	public void setDonos(Clientes[] donos) {
		this.donos = donos;
	}

	public Transacao[] getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(Transacao[] transacoes) {
		this.transacoes = transacoes;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getNumConta() {
		return numConta;
	}
	
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	public Date getDataUltMov() {
		return dataUltMov;
	}
	
	public void setDataUltMov(Date dataUltMov) {
		this.dataUltMov = dataUltMov;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}