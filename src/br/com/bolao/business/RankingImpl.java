package br.com.bolao.business;

import java.util.ArrayList;
import java.util.List;

import br.com.bolao.model.Rodada;
import br.com.bolao.model.ranking.Participante;

public class RankingImpl implements Ranking {

	@Override
	public void exibir(Rodada rodada) {
		List<Participante> participantes = processar(rodada);
		participantes.forEach(p -> String.format("%s %d %d %d %d", p.getPalpiteiro().getNome(), p.getPontuacao().getGeral(), p.getPontuacao().getAcertoVencedorCabeca(), p.getPontuacao().getAcertoPlacarVencerdor(), p.getPontuacao().getAcertoVencedor()));
	}
	
	private List<Participante> processar(Rodada rodada) {
		return new ArrayList<Participante>();
	}
}
