package br.com.bolao.model;

public class Palpite {
	
	private Usuario usuario;
	private Placar placar;

	public Palpite(String usuario, Placar placar) {
		this.usuario = new Usuario(usuario);
		this.placar = placar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Placar getPlacar() {
		return placar;
	}

	public String getNomeParticipante() {
		return usuario.getNome();
	}
}
