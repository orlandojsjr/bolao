package br.com.bolao.model.time;


public class Mandante extends Time implements Competidor {

	@Override
	public Integer getQtdeGol() {
		return 0;
	}
	
	@Override
	String getNome() {
		return super.nome;
	}
}
