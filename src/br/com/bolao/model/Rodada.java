package br.com.bolao.model;

import java.util.List;

public class Rodada {
	
	private List<Bolao> bolao;

	public Rodada(List<Bolao> bolao) {
		this.bolao = bolao;
	}

	public List<Bolao> getBolao() {
		return bolao;
	}
}
