package br.com.bolao.model;

public enum Pontos {
	
	ACERTO_VENCEDOR_NA_CABECA(3), 
	ACERTO_PLACAR_VENCEDOR(2), 
	ACERTO_VENCEDOR(1);
	
	private Integer pontos;
	
	private Pontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Integer getPontos() {
		return pontos;
	}
}
