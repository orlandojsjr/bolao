package test.bolao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.bolao.business.Ranking;
import br.com.bolao.business.RankingImpl;
import br.com.bolao.model.Bolao;
import br.com.bolao.model.Rodada;

public class BolaoTest {

	@Test
	public void test() {
		List<Bolao> bolaoList = new ArrayList();
		Rodada rodada = new Rodada(bolaoList);
		Ranking ranking = new RankingImpl();
		ranking.exibir(rodada);
	}
}
