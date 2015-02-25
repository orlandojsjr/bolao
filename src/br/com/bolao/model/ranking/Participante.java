package br.com.bolao.model.ranking;

import br.com.bolao.model.Pontos;
import br.com.bolao.model.Usuario;

public class Participante {

	private Usuario usuario;
	private Pontuacao pontuacao;
	
	public Participante(String nome, Pontuacao pontuacao) {
		this.usuario = new Usuario(nome);
		this.pontuacao = pontuacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Pontuacao getPontuacao() {
		return pontuacao;
	}
	
	public void atualizarPontuacao(Pontos pontos) {
		pontuacao.atualizarPontuacao(pontos);
	}
}
