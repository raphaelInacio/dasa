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
import com.dasa.domain.DadosParticipacaoCampanhaAnoResponse;
import com.dasa.service.CampanhasService;

@RestController
@RequestMapping("api/v1/campanhas")
public class CampanhaController {

	@Autowired
	CampanhasService service;
	
	@RequestMapping(value = "/", method = POST)
	public Campanha gravarDadosCampanha(@RequestBody Campanha campanha){
		return service.inserirCampanha(campanha);
	}
	
	@RequestMapping(value = "/anos/{ano}", method = GET)
	public DadosParticipacaoCampanhaAnoResponse obterDadosCampanhaPorAno(@PathVariable String ano){
		return service.obterDadosCampanhaPorAno(Optional.of(ano));
	}
	
	@RequestMapping("/id/{id}/anos/{ano}")
	public Campanha obterDadosCampanha(){
	//	DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of("2010"));
		//EstatisticaAnoResponse stat = new EstatisticaAnoResponse(pop);
		
		return null;	
	}
	
}
