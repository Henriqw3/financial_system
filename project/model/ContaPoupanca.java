package model;

import java.util.Date;

public class ContaPoupanca extends Conta {
	
	private Double rendimento;

	public ContaPoupanca(String senha, String numConta, Date dataAbertura, Date dataUltMov, Agencia agencia,
			Clientes[] donos, Double rendimento) {
		super(senha, numConta, dataAbertura, dataUltMov, agencia, donos);
		setRendimento(rendimento);
	}

	protected Double getRendimento() {
		return rendimento;
	}

	protected void setRendimento(Double rendimento) {
		this.rendimento = rendimento;
	}
	
	
}
