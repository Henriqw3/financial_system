package model;

public class Administrador {
	
	private String usuario = "groot";
	private String senha = "groot";
	
	public Administrador(String usuario, String senha) {
		super();
		setSenha(senha);
		setUsuario(usuario);
	}

	protected String getUsuario() {
		return usuario;
	}
	
	protected void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	protected String getSenha() {
		return senha;
	}
	
	protected void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
