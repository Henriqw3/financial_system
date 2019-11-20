package model;

public class Administrador {
	
	private String usuario = "groot";
	private String senha = "groot";
	
	public Administrador(String usuario, String senha) {
		super();
		setSenha(senha);
		setUsuario(usuario);
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
