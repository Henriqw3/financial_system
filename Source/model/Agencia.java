package model;

public class Agencia {
	private Integer numeroAgencia;
	private String nomeAgencia;
	private Endereco enderecoAgencia;
	private Associados[] associadosAgencia;
	private Conta[] contas;
	private Gerente gerenteAgencia;
	
	public Agencia() {}
	public Agencia(Integer numeroAgencia, String nomeAgencia, 
			Endereco enderecoAgencia, Gerente gerenteAgencia) {
		setAssociadosAgencia(associadosAgencia);
		setContas(contas);
		setEnderecoAgencia(enderecoAgencia);
		setGerenteAgencia(gerenteAgencia);
		setNomeAgencia(nomeAgencia);
		setNumeroAgencia(numeroAgencia);
	}

	public Conta[] getContas() {
		return contas;
	}

	public void setContas(Conta[] contas) {
		this.contas = contas;
	}

	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNomeAgencia() {
		return nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	public Endereco getEnderecoAgencia() {
		return enderecoAgencia;
	}

	public void setEnderecoAgencia(Endereco enderecoAgencia) {
		this.enderecoAgencia = enderecoAgencia;
	}

	public Associados[] getAssociadosAgencia() {
		return associadosAgencia;
	}

	public void setAssociadosAgencia(Associados[] associadoAgencia) {
		this.associadosAgencia = associadoAgencia;
	}

	public Gerente getGerenteAgencia() {
		return gerenteAgencia;
	}

	public void setGerenteAgencia(Gerente gerenteAgencia) {
		this.gerenteAgencia = gerenteAgencia;
	}
}
