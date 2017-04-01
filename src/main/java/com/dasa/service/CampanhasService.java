package com.dasa.service;

import java.util.Optional;

import com.dasa.domain.Campanha;


public interface CampanhasService {

    Campanha inserirCampanha(Campanha campanha);

	Iterable<Campanha> buscarInformacoesCampanhas(final Optional<String>  ano);

}
