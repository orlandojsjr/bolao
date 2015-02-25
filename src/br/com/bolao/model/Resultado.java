package br.com.bolao.model;


public class Resultado {
	
	private Integer golsMandante;
	private Integer golsVisitante;
	
	public Resultado(Integer golsMandante, Integer golsVisitante) {
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
