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

	protected Agencia getAgencia() {
		return agencia;
	}

	protected void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	protected Clientes[] getDonos() {
		return donos;
	}

	protected void setDonos(Clientes[] donos) {
		this.donos = donos;
	}

	protected Transacao[] getTransacoes() {
		return transacoes;
	}

	protected void setTransacoes(Transacao[] transacoes) {
		this.transacoes = transacoes;
	}

	protected String getSenha() {
		return senha;
	}

	protected void setSenha(String senha) {
		this.senha = senha;
	}
	
	protected Boolean getStatus() {
		return status;
	}
	
	protected void setStatus(Boolean status) {
		this.status = status;
	}
	
	protected String getNumConta() {
		return numConta;
	}
	
	protected void setNumConta(String numConta) {
		this.numConta = numConta;
	}
	
	protected Date getDataAbertura() {
		return dataAbertura;
	}
	
	protected void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	protected Date getDataUltMov() {
		return dataUltMov;
	}
	
	protected void setDataUltMov(Date dataUltMov) {
		this.dataUltMov = dataUltMov;
	}
	
	protected Double getSaldo() {
		return saldo;
	}
	
	protected void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}