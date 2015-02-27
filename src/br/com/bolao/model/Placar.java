package br.com.bolao.model;


public class Placar {
	
	private Integer golsMandante;
	private Integer golsVisitante;
	
	public Placar(Integer golsMandante, Integer golsVisitante) {
		this.golsMandante = golsMandante;
		this.golsVisitante = golsVisitante;
	}

	public Integer getGolsMandante() {
		return golsMandante;
	}

	public Integer getGolsVisitante() {
		return golsVisitante;
	}
	
	public Integer getPlacarVencedor() {
		if(golsMandante > golsVisitante) {
			return golsMandante;
		} else if(golsMandante < golsVisitante) {
			return golsVisitante;
		}
		return 0;
	}
	
	public boolean isEmpate() {
		return golsMandante == golsVisitante;
	}
}
