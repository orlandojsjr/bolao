package br.com.bolao.model;

import java.util.List;

public class Rodada {
	
	private List<Aposta> bolao;

	public Rodada(List<Aposta> bolao) {
		this.bolao = bolao;
	}

	public List<Aposta> getBolao() {
		return bolao;
	}
}
