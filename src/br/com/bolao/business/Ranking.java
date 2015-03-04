package br.com.bolao.business;

import java.util.List;

import br.com.bolao.model.ranking.Participante;

public interface Ranking {
	
	void exibir(List<Participante> participantes);
	
	List<Participante> getRankingOrdenado(List<Participante> participantes);
}
