package br.com.bolao.business;

import java.util.List;

import br.com.bolao.model.Bolao;
import br.com.bolao.model.ranking.Participante;

public interface BolaoBusiness {

	List<Participante> processar(Bolao bolao);
}
