package com.dasa.service;

import java.util.Optional;

import com.dasa.domain.Campanha;
import com.dasa.domain.ParticipacaoCampanhaAnoResponse;
import com.dasa.domain.ProporcaoParticipacaoCampanhaAnoResponse;

public interface CampanhasService {

	Campanha inserirCampanha(Campanha campanha);

	Iterable<Campanha> buscarInformacoesCampanhas(final Optional<String> ano);

	ParticipacaoCampanhaAnoResponse obterDadosCampanhaPorAno(Optional<String> ano);
	
	ProporcaoParticipacaoCampanhaAnoResponse obterProporcaoDadosCampanhaPorAno(Optional<String> ano);

}
