package br.com.bolao.model.ranking;

import br.com.bolao.model.Pontos;

public class Pontuacao {
	
	public Integer acertoVencedorCabeca = new Integer(0);
	public Integer acertoPlacarVencedor = new Integer(0);
	public Integer acertoVencedor = new Integer(0);
	
	public Integer getGeral() {
		return acertoVencedorCabeca + acertoPlacarVencedor + acertoVencedor;
	}
	public Integer getAcertoVencedorCabeca() {
		return acertoVencedorCabeca;
	}
	public Integer getAcertoPlacarVencedor() {
		return acertoPlacarVencedor;
	}
	public Integer getAcertoVencedor() {
		return acertoVencedor;
	}
	
	public void atualizarPontuacao(Pontos pontos) {
		switch(pontos) {
			case ACERTO_VENCEDOR_NA_CABECA: 
				acertoVencedorCabeca += pontos.getPontos();
			break;
			case ACERTO_PLACAR_VENCEDOR: 
				acertoPlacarVencedor += pontos.getPontos();
			break;
			case ACERTO_VENCEDOR: 
				acertoVencedor += pontos.getPontos();
			break;
		}
	}
}