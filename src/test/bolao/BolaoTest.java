package test.bolao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.bolao.business.Ranking;
import br.com.bolao.business.RankingImpl;
import br.com.bolao.model.Jogo;
import br.com.bolao.model.Rodada;

public class BolaoTest {

	@Test
	public void test() {
		List<Jogo> jogos = new ArrayList();
		Rodada rodada = new Rodada(jogos);
		Ranking ranking = new RankingImpl();
		ranking.exibir(rodada);
	}
}
