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

	public Double getLimiteCE() {
		return limiteCE;
	}

	public void setLimiteCE(Double limiteCE) {
		this.limiteCE = limiteCE;
	}

	public Double getTaxaADM() {
		return taxaADM;
	}

	public void setTaxaADM(Double taxaADM) {
		this.taxaADM = taxaADM;
	}
}