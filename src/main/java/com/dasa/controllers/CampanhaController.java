package com.dasa.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dasa.domain.DadoPopulacional;
import com.dasa.domain.EstatisticaAnoResponse;
import com.dasa.service.DadosPopulacionaisService;

@RestController
@RequestMapping("api/v1/campanhas/")
public class CampanhaController {

	@Autowired
	DadosPopulacionaisService service;
	
	@RequestMapping(value = "/", method = POST)
	public EstatisticaAnoResponse gravarDadosCampanha(){
		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of("2010"));
		EstatisticaAnoResponse stat = new EstatisticaAnoResponse(pop);
		
		return stat;	
	}
	
	@RequestMapping(value = "/anos/{ano}", method = GET)
	public EstatisticaAnoResponse obterDadosCampanhaPorAno(){
		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of("2010"));
		EstatisticaAnoResponse stat = new EstatisticaAnoResponse(pop);
		
		return stat;	
	}
	
	@RequestMapping("/id/{id}/anos/{ano}")
	public EstatisticaAnoResponse obterDadosCampanha(){
		DadoPopulacional pop = service.obterPopulacaoPorAno(Optional.of("2010"));
		EstatisticaAnoResponse stat = new EstatisticaAnoResponse(pop);
		
		return stat;	
	}
	
}
