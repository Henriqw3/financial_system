package model;

public class Endereco {
	
	private String cep;
	private Integer numEnd;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	
	public Endereco(String cep, Integer numEnd, String rua, String bairro, String cidade, String estado) {
		super();
		setBairro(bairro);
		setCep(cep);
		setCidade(cidade);
		setEstado(estado);
		setNumEnd(numEnd);
		setRua(rua);
	}

	protected String getCep() {
		return cep;
	}
	
	protected void setCep(String cep) {
		this.cep = cep;
	}
	
	protected Integer getNumEnd() {
		return numEnd;
	}
	
	protected void setNumEnd(Integer numEnd) {
		this.numEnd = numEnd;
	}
	
	protected String getRua() {
		return rua;
	}
	
	protected void setRua(String rua) {
		this.rua = rua;
	}
	
	protected String getBairro() {
		return bairro;
	}
	
	protected void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	protected String getCidade() {
		return cidade;
	}
	
	protected void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	protected String getEstado() {
		return estado;
	}
	
	protected void setEstado(String estado) {
		this.estado = estado;
	}

}
