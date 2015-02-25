package br.com.bolao.model;

public class Palpite {
	
	private Usuario usuario;
	private Resultado placar;

	public Palpite(String usuario, Resultado placar) {
		this.usuario = new Usuario(usuario);
		this.placar = placar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Resultado getPlacar() {
		return placar;
	}
}
