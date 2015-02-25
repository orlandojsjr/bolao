package br.com.bolao.business;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bolao.model.ranking.Participante;

public class RankingImpl implements Ranking {

	@Override
	public void exibir(List<Participante> participantes) {
		getRankingOrdenado(participantes).forEach(p -> System.out.println(String.format("%s %d %d %d %d", p.getUsuario().getNome(), p.getPontuacao().getGeral(), p.getPontuacao().getAcertoVencedorCabeca(), p.getPontuacao().getAcertoPlacarVencedor(), p.getPontuacao().getAcertoVencedor())));
	}
	
	@Override
	public List<Participante> getRankingOrdenado(List<Participante> participantes) {
		participantes.sort(Comparator.comparing(p -> p.getPontuacao().getGeral()));
		Collections.reverse(participantes);
		return participantes;
	}
}
