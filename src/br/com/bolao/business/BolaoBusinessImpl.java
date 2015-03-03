package br.com.bolao.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.bolao.business.strategy.PontuacaoStrategy;
import br.com.bolao.model.Aposta;
import br.com.bolao.model.Bolao;
import br.com.bolao.model.Placar;
import br.com.bolao.model.ranking.Participante;
import br.com.bolao.model.ranking.Pontuacao;

public class BolaoBusinessImpl implements BolaoBusiness {

	Map<String, Participante> participantes = new HashMap();
	PontuacaoStrategy pontuacaoStrategy = new PontuacaoStrategy();
	
	private void atualizarPontos(Placar placar, Placar placarPalpite, String nomeParticipante) {
		pontuacaoStrategy.atualizar(placar, placarPalpite, getParticipante(nomeParticipante).getPontuacao());
	}
	
	private Participante getParticipante(String nome) {
		if(!participantes.containsKey(nome)) {
			participantes.put(nome, new Participante(nome, new Pontuacao()));
		}
		return participantes.get(nome);
	}
	
	private void processarAposta(Aposta aposta) {
		aposta.getPalpites().forEach(p -> atualizarPontos(aposta.getPartida().getPlacar(), p.getPlacar(), p.getNomeParticipante()));
	}
	
	@Override 
	public List<Participante> processar(Bolao bolao) {
		bolao.getApostas().forEach(aposta -> processarAposta(aposta));
		return new ArrayList<>(participantes.values());
	}
}
