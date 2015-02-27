package test.bolao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.bolao.business.BolaoBusiness;
import br.com.bolao.business.BolaoBusinessImpl;
import br.com.bolao.business.Ranking;
import br.com.bolao.business.RankingImpl;
import br.com.bolao.model.Bolao;
import br.com.bolao.model.Palpite;
import br.com.bolao.model.Partida;
import br.com.bolao.model.Placar;
import br.com.bolao.model.ranking.Participante;
import br.com.bolao.model.time.Time;

public class BolaoTest {
	
	Time mandante = new Time("Sao Paulo");
	Time visitante = new Time("Corinthians");
	Placar resultado = new Placar(5, 0);
	Partida partida = new Partida(mandante, visitante, resultado);
	
	@SuppressWarnings("unchecked")
	List<Palpite> palpites = new ArrayList() {{
		add(new Palpite("Orlando", new Placar(5,0)));
		add(new Palpite("Arthur", new Placar(5,2)));
		add(new Palpite("Bjornn", new Placar(1,0)));
	}};
	Bolao bolao = new Bolao(partida, palpites);
	
	@Test
	public void test() {
		Ranking ranking = new RankingImpl();
		BolaoBusiness business = new BolaoBusinessImpl();
		List<Participante> participantes = business.processar(bolao);
		participantes = ranking.getRankingOrdenado(participantes);
		
		Assert.assertEquals(participantes.get(0).getUsuario().getNome(), "Orlando");
		Assert.assertEquals(participantes.get(0).getPontuacao().getGeral().intValue(), 6);
		Assert.assertEquals(participantes.get(0).getPontuacao().getAcertoVencedorCabeca().intValue(), 3);
		Assert.assertEquals(participantes.get(0).getPontuacao().getAcertoPlacarVencedor().intValue(), 2);
		Assert.assertEquals(participantes.get(0).getPontuacao().getAcertoVencedor().intValue(), 1);
		
		Assert.assertEquals(participantes.get(1).getUsuario().getNome(), "Arthur");
		Assert.assertEquals(participantes.get(1).getPontuacao().getGeral().intValue(), 3);
		Assert.assertEquals(participantes.get(1).getPontuacao().getAcertoVencedorCabeca().intValue(), 0);
		Assert.assertEquals(participantes.get(1).getPontuacao().getAcertoPlacarVencedor().intValue(), 2);
		Assert.assertEquals(participantes.get(1).getPontuacao().getAcertoVencedor().intValue(), 1);
		
		Assert.assertEquals(participantes.get(2).getUsuario().getNome(), "Bjornn");
		Assert.assertEquals(participantes.get(2).getPontuacao().getGeral().intValue(), 1);
		Assert.assertEquals(participantes.get(2).getPontuacao().getAcertoVencedorCabeca().intValue(), 0);
		Assert.assertEquals(participantes.get(2).getPontuacao().getAcertoPlacarVencedor().intValue(), 0);
		Assert.assertEquals(participantes.get(2).getPontuacao().getAcertoVencedor().intValue(), 1);
	}
}
