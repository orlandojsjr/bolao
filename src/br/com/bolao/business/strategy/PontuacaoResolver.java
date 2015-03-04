package br.com.bolao.business.strategy;

import java.util.Arrays;
import java.util.List;

import br.com.bolao.model.Placar;
import br.com.bolao.model.Pontos;
import br.com.bolao.model.ranking.Pontuacao;

public class PontuacaoResolver {
	
	List<PontuacaoInterface> resolvers = Arrays.asList(new AcertoNaCabeca(), new AcertoPlacarVencedor(), new AcertoVencedor()); 
	
	public Pontuacao atualizar(Placar placar, Placar placarPalpite, Pontuacao pontuacao) {
		for (PontuacaoInterface resolver : resolvers) {
			pontuacao = resolver.atualizar(placar, placarPalpite, pontuacao);
		}
		return pontuacao;
	} 
	
	private interface PontuacaoInterface {
		Pontuacao atualizar(Placar placar, Placar placarPalpite, Pontuacao pontuacao);
	}

	private class AcertoNaCabeca implements PontuacaoInterface {
		@Override
		public Pontuacao atualizar(Placar placar, Placar placarPalpite, Pontuacao pontuacao) {
			if (placar.getGolsMandante() == placarPalpite.getGolsMandante() && placar.getGolsVisitante() == placarPalpite.getGolsVisitante()) {
				pontuacao.setAcertoVencedorCabeca(pontuacao.getAcertoVencedorCabeca() + Pontos.ACERTO_VENCEDOR_NA_CABECA.getPontos());
			}
			return pontuacao;
		}
	}
	
	private class AcertoPlacarVencedor implements PontuacaoInterface {
		@Override
		public Pontuacao atualizar(Placar placar, Placar placarPalpite, Pontuacao pontuacao) {
			if (placar.getPlacarVencedor() == placarPalpite.getPlacarVencedor()) {
				pontuacao.setAcertoPlacarVencedor(pontuacao.getAcertoPlacarVencedor() + Pontos.ACERTO_PLACAR_VENCEDOR.getPontos());
			}
			return pontuacao;
		}
	}
	
	private class AcertoVencedor implements PontuacaoInterface {
		@Override
		public Pontuacao atualizar(Placar placar, Placar placarPalpite, Pontuacao pontuacao) {
			if(!placar.isEmpate() && (placar.getGolsMandante() > placar.getGolsVisitante() &&  placarPalpite.getGolsMandante() > placarPalpite.getGolsVisitante())) {
				pontuacao.setAcertoVencedor(pontuacao.getAcertoVencedor() + Pontos.ACERTO_VENCEDOR.getPontos());
			}
			return pontuacao;
		}
	}
}
