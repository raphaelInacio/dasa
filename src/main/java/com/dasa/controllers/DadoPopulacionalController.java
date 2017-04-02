package com.dasa.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.CrescimentoPopulacional;
import com.dasa.domain.DadoPopulacional;
import com.dasa.domain.EstatisticaAnoResponse;
import com.dasa.service.DadosPopulacionaisService;

@RestController
@RequestMapping("api/v1/dado-populacional")
public class DadoPopulacionalController {

	@Autowired
	DadosPopulacionaisService service;

	@RequestMapping(value = "/anos/{ano}", method = GET)
	public EstatisticaAnoResponse obterDadosPopulacaoGeralPorAno(@PathVariable("ano") String ano) {
		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of(ano));
		EstatisticaAnoResponse stat = new EstatisticaAnoResponse(pop);

		return stat;
	}

	@RequestMapping(value = "/taxa-crescimento/ano-base/{ano-base}/ano-pesquisa/{ano-pesquisa}", method = GET)
	public CrescimentoPopulacional obterDadosDeTodasCampanhas(@PathVariable("ano-base") String anoBase,
			@PathVariable("ano-pesquisa") String anoPesquisa) {
		CrescimentoPopulacional crescimentoPopulacional = service .obterTaxaDeCrescimentoPopulacional(Optional.of(anoBase), Optional.of(anoPesquisa));
		return crescimentoPopulacional;
	}

}
