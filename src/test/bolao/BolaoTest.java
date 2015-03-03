package test.bolao;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.bolao.business.BolaoBusiness;
import br.com.bolao.business.BolaoBusinessImpl;
import br.com.bolao.business.Ranking;
import br.com.bolao.business.RankingImpl;
import br.com.bolao.model.Aposta;
import br.com.bolao.model.Bolao;
import br.com.bolao.model.Palpite;
import br.com.bolao.model.Partida;
import br.com.bolao.model.Placar;
import br.com.bolao.model.Time;
import br.com.bolao.model.ranking.Participante;

public class BolaoTest {
	
	Ranking ranking = new RankingImpl();
	BolaoBusiness business = new BolaoBusinessImpl();
	
	//TODO FIXTURE
	//partida 1
	Time mandante = new Time("Sao Paulo");
	Time visitante = new Time("Corinthians");
	Placar resultado = new Placar(5, 0);
	Partida partida = new Partida(mandante, visitante, resultado);
	
	@SuppressWarnings("unchecked")
	List<Palpite> palpites = new ArrayList() {{
		add(new Palpite("Orlando", new Placar(5, 0)));
		add(new Palpite("Arthur", new Placar(5, 2)));
		add(new Palpite("Bjornn", new Placar(1, 0)));
	}};
	Aposta aposta = new Aposta(partida, palpites);
	
	//partida 2
	Time mandante2 = new Time("Sao Paulo");
	Time visitante2 = new Time("Botafogo");
	Placar resultado2 = new Placar(2, 1);
	Partida partida2 = new Partida(mandante2, visitante2, resultado2);
	
	@SuppressWarnings("unchecked")
	List<Palpite> palpites2 = new ArrayList() {{
		add(new Palpite("Orlando", new Placar(2, 1)));
		add(new Palpite("Arthur", new Placar(2, 0)));
		add(new Palpite("Bjornn", new Placar(0, 1)));
	}};
	Aposta aposta2 = new Aposta(partida2, palpites2);
	
	
	//partida 3
	Time mandante3 = new Time("Sao Paulo");
	Time visitante3 = new Time("Palmeiras");
	Placar resultado3 = new Placar(3, 2);
	Partida partida3 = new Partida(mandante3, visitante3, resultado3);
	
	@SuppressWarnings("unchecked")
	List<Palpite> palpites3 = new ArrayList() {{
		add(new Palpite("Orlando", new Placar(3, 1)));
		add(new Palpite("Arthur", new Placar(1, 1)));
		add(new Palpite("Bjornn", new Placar(3, 2)));
	}};
	Aposta aposta3 = new Aposta(partida3, palpites3);
	
	Bolao bolaoUmaAposta = new Bolao(Arrays.asList(aposta));
	Bolao bolaoVariasApostas = new Bolao(Arrays.asList(aposta, aposta2, aposta3));
	
	@Test
	public void test() {
		List<Participante> participantes = business.processar(bolaoUmaAposta);
		participantes = ranking.getRankingOrdenado(participantes);
		ranking.exibir(participantes);
		
		assertEquals(participantes.get(0).getUsuario().getNome(), "Orlando");
		assertEquals(participantes.get(0).getPontuacao().getGeral().intValue(), 6);
		assertEquals(participantes.get(0).getPontuacao().getAcertoVencedorCabeca().intValue(), 3);
		assertEquals(participantes.get(0).getPontuacao().getAcertoPlacarVencedor().intValue(), 2);
		assertEquals(participantes.get(0).getPontuacao().getAcertoVencedor().intValue(), 1);
		
		assertEquals(participantes.get(1).getUsuario().getNome(), "Arthur");
		assertEquals(participantes.get(1).getPontuacao().getGeral().intValue(), 3);
		assertEquals(participantes.get(1).getPontuacao().getAcertoVencedorCabeca().intValue(), 0);
		assertEquals(participantes.get(1).getPontuacao().getAcertoPlacarVencedor().intValue(), 2);
		assertEquals(participantes.get(1).getPontuacao().getAcertoVencedor().intValue(), 1);
		
		assertEquals(participantes.get(2).getUsuario().getNome(), "Bjornn");
		assertEquals(participantes.get(2).getPontuacao().getGeral().intValue(), 1);
		assertEquals(participantes.get(2).getPontuacao().getAcertoVencedorCabeca().intValue(), 0);
		assertEquals(participantes.get(2).getPontuacao().getAcertoPlacarVencedor().intValue(), 0);
		assertEquals(participantes.get(2).getPontuacao().getAcertoVencedor().intValue(), 1);
	}
	
	
	@Test
	public void testVariasApostas() {
		List<Participante> participantes = business.processar(bolaoVariasApostas);
		participantes = ranking.getRankingOrdenado(participantes);
		ranking.exibir(participantes);
		
		assertEquals(participantes.get(0).getUsuario().getNome(), "Orlando");
		assertEquals(participantes.get(0).getPontuacao().getGeral().intValue(), 15);
		assertEquals(participantes.get(0).getPontuacao().getAcertoVencedorCabeca().intValue(), 6);
		assertEquals(participantes.get(0).getPontuacao().getAcertoPlacarVencedor().intValue(), 6);
		assertEquals(participantes.get(0).getPontuacao().getAcertoVencedor().intValue(), 3);
		
		assertEquals(participantes.get(1).getUsuario().getNome(), "Bjornn");
		assertEquals(participantes.get(1).getPontuacao().getGeral().intValue(), 7);
		assertEquals(participantes.get(1).getPontuacao().getAcertoVencedorCabeca().intValue(), 3);
		assertEquals(participantes.get(1).getPontuacao().getAcertoPlacarVencedor().intValue(), 2);
		assertEquals(participantes.get(1).getPontuacao().getAcertoVencedor().intValue(), 2);
		
		assertEquals(participantes.get(2).getUsuario().getNome(), "Arthur");
		assertEquals(participantes.get(2).getPontuacao().getGeral().intValue(), 6);
		assertEquals(participantes.get(2).getPontuacao().getAcertoVencedorCabeca().intValue(), 0);
		assertEquals(participantes.get(2).getPontuacao().getAcertoPlacarVencedor().intValue(), 4);
		assertEquals(participantes.get(2).getPontuacao().getAcertoVencedor().intValue(), 2);
	}
}
