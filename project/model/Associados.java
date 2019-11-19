package model;
import java.util.Date;

public abstract class Associados 
{
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private Character sexo;
	private String rg;
	private String estadoCivil;
	
	protected String getNome() 
	{
		return nome;
	}
	protected String getCpf() 
	{
		return cpf;
	}
	protected Date getDataNascimento() 
	{
		return dataNascimento;
	}
	protected Character getSexo() 
	{
		return sexo;
	}
	protected String getRg() 
	{
		return rg;
	}
	protected String getEstadoCivil() 
	{
		return estadoCivil;
	}
	protected void setNome(String nome) 
	{
		this.nome = nome;
	}
	protected boolean setCpf(String cpfString)
	{
		if (cpfString.length() == 11) {
			
			if( cpfString != "00000000000" &&
				cpfString != "11111111111" &&
				cpfString != "22222222222" &&
				cpfString != "33333333333" &&
				cpfString != "44444444444" &&
				cpfString != "55555555555" &&
				cpfString != "66666666666" &&
				cpfString != "77777777777" &&
				cpfString != "88888888888" &&
				cpfString != "99999999999") {
				
				int result = 0;
				for (int i = 10, j = 0; i >= 2; i--, j++) {
					result += ((int) cpfString.charAt(j) - 48) * i;
				}
				
				if ((result*10) % 11 == ((int) cpfString.charAt(9) - 48)) {
					result = 0;
					for (int i = 11, j = 0; i >= 2; i--, j++) {
						result += ((int) cpfString.charAt(j) - 48) * i;
					}
					
					if ((result*10) % 11 == (int) cpfString.charAt(10) - 48) {
						this.cpf = cpfString;
						return true;
					}
				}
				
			}//To pass String cpf to number and verify number
		
		} return false;
	}
	protected void setDataNascimento(Date dataNascimento) 
	{
		this.dataNascimento = dataNascimento;
	}
	protected void setSexo(Character sexo) 
	{
		this.sexo = sexo; // tratar na interface
	}
	protected boolean setRg(String rg) 
	{
		if(rg.length() == 10)
		{
			this.rg = rg; // sigla do estado tratar na interface
			return true;
		}
		else
			return false;
	}
	protected void setEstadoCivil(String estadoCivil) 
	{
		this.estadoCivil = estadoCivil; // tratado na interface
	}
}
