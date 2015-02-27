package br.com.bolao.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.bolao.model.Bolao;
import br.com.bolao.model.Palpite;
import br.com.bolao.model.Pontos;
import br.com.bolao.model.Placar;
import br.com.bolao.model.ranking.Participante;
import br.com.bolao.model.ranking.Pontuacao;

public class BolaoBusinessImpl implements BolaoBusiness {

	Map<String, Participante> participantes = new HashMap();
	
	private void calcularPontos(Placar placar, Palpite palpite) {
		Placar placarPalpite = palpite.getPlacar();
		Participante participante = getParticipante(palpite.getUsuario().getNome());
		
		if(acertouNaCabeca(placar, placarPalpite)) {
			participante.atualizarPontuacao(Pontos.ACERTO_VENCEDOR_NA_CABECA);
		} 
		
		if(acertouPlacarVencedor(placar, placarPalpite)) {
			participante.atualizarPontuacao(Pontos.ACERTO_PLACAR_VENCEDOR);
		} 
		
		if(acertouVencedor(placar, placarPalpite)) {
			participante.atualizarPontuacao(Pontos.ACERTO_VENCEDOR);
		}
	}
	
	private boolean acertouNaCabeca(Placar placar, Placar placarPalpite) {
		return placar.getGolsMandante() == placarPalpite.getGolsMandante() && placar.getGolsVisitante() == placarPalpite.getGolsVisitante();
	}
	
	private boolean acertouPlacarVencedor(Placar placar, Placar placarPalpite) {
		return placar.getPlacarVencedor() == placarPalpite.getPlacarVencedor();
	}
	
	private boolean acertouVencedor(Placar placar, Placar placarPalpite) {
		return !placar.isEmpate() && (placar.getGolsMandante() > placar.getGolsVisitante() &&  placarPalpite.getGolsMandante() > placarPalpite.getGolsVisitante());
		
	}
		
	private Participante getParticipante(String nome) {
		if(!participantes.containsKey(nome)) {
			participantes.put(nome, new Participante(nome, new Pontuacao()));
		}
		return participantes.get(nome);
	}
	
	@Override
	public List<Participante> processar(Bolao bolao) {
		Placar placar = bolao.getPartida().getPlacar();
		bolao.getPalpites().forEach(p -> calcularPontos(placar, p));
		return new ArrayList<>(participantes.values());
	}

	@Override
	public List<Participante> processar(List<Bolao> bolaoList) {
		return null;
	}
}
