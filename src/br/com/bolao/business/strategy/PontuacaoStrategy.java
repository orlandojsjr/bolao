package br.com.bolao.business.strategy;

import java.util.Arrays;
import java.util.List;

import br.com.bolao.model.Placar;
import br.com.bolao.model.Pontos;
import br.com.bolao.model.ranking.Pontuacao;

public class PontuacaoStrategy {
	
	List<PontuacaoInterface> strategies = Arrays.asList(new AcertoNaCabeca(), new AcertoPlacarVencedor(), new AcertoVencedor()); 
	
	public void atualizar(Placar placar, Placar placarPalpite, Pontuacao pontuacao) {
		strategies.forEach(s -> s.atualizar(placar, placarPalpite, pontuacao));
	} 
	
	private interface PontuacaoInterface {
		void atualizar(Placar placar, Placar placarPalpite, Pontuacao pontuacao);
	}

	private class AcertoNaCabeca implements PontuacaoInterface {
		@Override
		public void atualizar(Placar placar, Placar placarPalpite, Pontuacao pontuacao) {
			if (placar.getGolsMandante() == placarPalpite.getGolsMandante() && placar.getGolsVisitante() == placarPalpite.getGolsVisitante())
				pontuacao.atualizarPontuacao(Pontos.ACERTO_VENCEDOR_NA_CABECA);
		}
	}
	
	private class AcertoPlacarVencedor implements PontuacaoInterface {
		@Override
		public void atualizar(Placar placar, Placar placarPalpite, Pontuacao pontuacao) {
			if (placar.getPlacarVencedor() == placarPalpite.getPlacarVencedor())
				pontuacao.atualizarPontuacao(Pontos.ACERTO_PLACAR_VENCEDOR) ;
		}
	}
	
	private class AcertoVencedor implements PontuacaoInterface {
		@Override
		public void atualizar(Placar placar, Placar placarPalpite, Pontuacao pontuacao) {
			if(!placar.isEmpate() && (placar.getGolsMandante() > placar.getGolsVisitante() &&  placarPalpite.getGolsMandante() > placarPalpite.getGolsVisitante()))
				pontuacao.atualizarPontuacao(Pontos.ACERTO_VENCEDOR);
		}
	}
}
