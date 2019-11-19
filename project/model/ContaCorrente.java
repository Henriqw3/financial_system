package model;

import java.util.Date;

class ContaCorrente extends Conta{
	private Double limiteCE;
	private Double taxaADM;

	public ContaCorrente(String senha, String numConta, Date dataAbertura, Date dataUltMov, Agencia agencia,
			Clientes[] donos, Double limiteCE, Double taxaADM) {
		super(senha, numConta, dataAbertura, dataUltMov, agencia, donos);
		setLimiteCE(limiteCE);
		setTaxaADM(taxaADM);
	}

	protected Double getLimiteCE() {
		return limiteCE;
	}

	protected void setLimiteCE(Double limiteCE) {
		this.limiteCE = limiteCE;
	}

	protected Double getTaxaADM() {
		return taxaADM;
	}

	protected void setTaxaADM(Double taxaADM) {
		this.taxaADM = taxaADM;
	}
}