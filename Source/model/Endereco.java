package model;

public class Endereco {
	
	private String cep;
	private int numEnd;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String complemento;
	

	public Endereco(String cep, int numEnd, String rua, String bairro, String cidade, String estado, String complemento) {
		super();
		setBairro(bairro);
		setCep(cep);
		setCidade(cidade);
		setEstado(estado);
		setNumEnd(numEnd);
		setRua(rua);
		setComplemento(complemento);
	}

	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public int getNumEnd() {
		return numEnd;
	}
	
	public void setNumEnd(int numEnd) {
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
