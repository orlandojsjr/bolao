package br.com.bolao.model;

import java.util.List;

public class Bolao {
	
	private Partida partida;
	private List<Palpite> palpites;
	
	public Bolao(Partida partida, List<Palpite> palpites) {
		this.partida = partida;
		this.palpites = palpites;
	}

	public Partida getPartida() {
		return partida;
	}

	public List<Palpite> getPalpites() {
		return palpites;
	}
}
