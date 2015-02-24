package br.com.bolao.model.ranking;

import br.com.bolao.model.Palpiteiro;

public class Participante {

	private Palpiteiro palpiteiro;
	private Pontuacao pontuacao;
	
	public Participante(Palpiteiro palpiteiro, Pontuacao pontuacao) {
		this.palpiteiro = palpiteiro;
		this.pontuacao = pontuacao;
	}
	public Palpiteiro getPalpiteiro() {
		return palpiteiro;
	}
	public Pontuacao getPontuacao() {
		return pontuacao;
	}
}
