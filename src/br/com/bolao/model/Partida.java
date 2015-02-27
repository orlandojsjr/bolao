package br.com.bolao.model;

import br.com.bolao.model.time.Time;

public class Partida {
	
	private Time mandante;
	private Time visitante;
	private Placar placar;

	public Partida(Time mandante, Time visitante, Placar placar) {
		this.mandante = mandante;
		this.visitante = visitante;
		this.placar = placar;
	}

	public Time getMandante() {
		return mandante;
	}

	public Time getVisitante() {
		return visitante;
	}

	public Placar getPlacar() {
		return placar;
	}
}
