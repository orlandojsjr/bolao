package br.com.bolao.model;

import br.com.bolao.model.time.Time;

public class Partida {
	
	private Time mandante;
	private Time visitante;
	private Resultado placar;

	public Partida(Time mandante, Time visitante, Resultado placar) {
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

	public Resultado getPlacar() {
		return placar;
	}
}
