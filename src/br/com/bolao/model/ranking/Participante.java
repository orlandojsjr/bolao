package br.com.bolao.model.ranking;

import br.com.bolao.model.Usuario;

public class Participante {

	private Usuario usuario;
	private Pontuacao pontuacao;
	
	public Participante(Usuario usuario, Pontuacao pontuacao) {
		this.usuario = usuario;
		this.pontuacao = pontuacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Pontuacao getPontuacao() {
		return pontuacao;
	}
}
