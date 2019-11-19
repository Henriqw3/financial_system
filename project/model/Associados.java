package model;
import java.util.Date;

public abstract class Associados {
	
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private Character sexo;
	private String rg;
	private String estadoCivil;
	private Agencia agencia;
	private Endereco endereco;
	
	public Associados(String nome, String cpf, Date dataNascimento, Character sexo, String rg, String estadoCivil,
			Agencia agencia, Endereco endereco) {
		super();
		setAgencia(agencia);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setEndereco(endereco);
		setEstadoCivil(estadoCivil);
		setNome(nome);
		setRg(rg);
		setSexo(sexo);
	}

	protected Agencia getAgencia() {
		return agencia;
	}

	protected void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	protected Endereco getEndereco() {
		return endereco;
	}

	protected void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	protected String getNome() {
		return nome;
	}
	
	protected String getCpf() {
		return cpf;
	}
	
	protected Date getDataNascimento() {
		return dataNascimento;
	}
	
	protected Character getSexo() {
		return sexo;
	}
	
	protected String getRg() {
		return rg;
	}
	
	protected String getEstadoCivil() {
		return estadoCivil;
	}
	
	protected void setNome(String nome) {
		this.nome = nome;
	}
	
	protected boolean setCpf(String cpf) {
		if (cpf.length() == 11) {
			
			if( cpf != "00000000000" &&
				cpf != "11111111111" &&
				cpf != "22222222222" &&
				cpf != "33333333333" &&
				cpf != "44444444444" &&
				cpf != "55555555555" &&
				cpf != "66666666666" &&
				cpf != "77777777777" &&
				cpf != "88888888888" &&
				cpf != "99999999999") {
				
				int result = 0;
				for (int i = 10, j = 0; i >= 2; i--, j++) {
					result += ((int) cpf.charAt(j) - 48) * i;
				}
				
				if ((result*10) % 11 == ((int) cpf.charAt(9) - 48)) {
					result = 0;
					for (int i = 11, j = 0; i >= 2; i--, j++) {
						result += ((int) cpf.charAt(j) - 48) * i;
					}
					
					if ((result*10) % 11 == (int) cpf.charAt(10) - 48) {
						this.cpf = cpf;
						return true;
					}
				}
				
			}
		
		} return false;
	}
	
	protected void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	protected void setSexo(Character sexo) {
		this.sexo = sexo; 
	}
	
	protected boolean setRg(String rg) {
		if(rg.length() == 10)
		{
			this.rg = rg; 
			return true;
		}
		else
			return false;
	}
	
	protected void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil; 
	}
}
