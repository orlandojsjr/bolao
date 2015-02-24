package br.com.bolao.model;

import java.util.List;

public class Rodada {
	
	private List<Jogo> jogos;

	public Rodada(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}
}
