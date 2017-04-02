package com.dasa.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.Campanha;
import com.dasa.domain.ParticipacaoCampanhaAnoResponse;
import com.dasa.domain.ProporcaoParticipacaoCampanhaAnoResponse;
import com.dasa.service.CampanhasService;

@RestController
@RequestMapping("api/v1/campanhas")
public class CampanhaController {

	@Autowired
	CampanhasService service;

	@RequestMapping(value = "/", method = POST)
	public Campanha gravarDadosCampanha(@RequestBody Campanha campanha) {
		return service.inserirCampanha(campanha);
	}

	@RequestMapping(value = "/anos/{ano}", method = GET)
	public ParticipacaoCampanhaAnoResponse obterDadosCampanhaPorAno(@PathVariable String ano) {
		return service.obterDadosCampanhaPorAno(Optional.of(ano));
	}

	@RequestMapping(value = "/proporcao/anos/{ano}", method = GET)
	public ProporcaoParticipacaoCampanhaAnoResponse obterProporcaoDadosCampanhaPorAno(@PathVariable String ano) {
		return service.obterProporcaoDadosCampanhaPorAno(Optional.of(ano));
	}

}
