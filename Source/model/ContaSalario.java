package model;

import java.util.Date;

class ContaSalario extends Conta{
	private Double limiteSaque;
	private Double limiteTrans;

	public ContaSalario(String senha, String numConta, Date dataAbertura, Date dataUltMov, Agencia agencia,
			Clientes[] donos, Double limiteSaque, Double limiteTrans) {
		super(senha, numConta, dataAbertura, dataUltMov, agencia, donos);
		setLimiteSaque(limiteSaque);
		setLimiteTrans(limiteTrans);
	}

	protected Double getLimiteSaque() {
		return limiteSaque;
	}

	protected void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	protected Double getLimiteTrans() {
		return limiteTrans;
	}

	protected void setLimiteTrans(Double limiteTrans) {
		this.limiteTrans = limiteTrans;
	}

}