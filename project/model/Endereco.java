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

	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Integer getNumEnd() {
		return numEnd;
	}
	
	public void setNumEnd(Integer numEnd) {
		this.numEnd = numEnd;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
