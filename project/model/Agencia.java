package model;

public class Agencia {
	private String numeroAgencia;
	private String nomeAgencia;
	private Endereco enderecoAgencia;
	private Associados[] associadosAgencia;
	private Gerente gerenteAgencia;
	
	protected Agencia(String numeroAgencia, String nomeAgencia, Endereco enderecoAgencia,
			Associados[] associadosAgencia, Gerente gerenteAgencia) {
		super();
		setAssociadosAgencia(associadosAgencia);
		setEnderecoAgencia(enderecoAgencia);
		setGerenteAgencia(gerenteAgencia);
		setNomeAgencia(nomeAgencia);
		setNumeroAgencia(numeroAgencia);
	}

	protected String getNumeroAgencia() {
		return numeroAgencia;
	}

	protected void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	protected String getNomeAgencia() {
		return nomeAgencia;
	}

	protected void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	protected Endereco getEnderecoAgencia() {
		return enderecoAgencia;
	}

	protected void setEnderecoAgencia(Endereco enderecoAgencia) {
		this.enderecoAgencia = enderecoAgencia;
	}

	protected Associados[] getAssociadosAgencia() {
		return associadosAgencia;
	}

	protected void setAssociadosAgencia(Associados[] associadoAgencia) {
		this.associadosAgencia = associadoAgencia;
	}

	protected Gerente getGerenteAgencia() {
		return gerenteAgencia;
	}

	protected void setGerenteAgencia(Gerente gerenteAgencia) {
		this.gerenteAgencia = gerenteAgencia;
	}
}
