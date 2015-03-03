package br.com.bolao.model;

import java.util.List;

public class Bolao {
	
	private List<Aposta> apostas;

	public Bolao(List<Aposta> apostas) {
		this.apostas = apostas;
	}

	public List<Aposta> getApostas() {
		return apostas;
	}
}
