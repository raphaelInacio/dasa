package com.dasa.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.dasa.domain.Campanha;
import com.dasa.domain.TipoCampanha;

@Transactional
public interface CampanhasRepository extends CrudRepository<Campanha, Long> {
	Iterable<Campanha> findByAnoAndCampanha(final String ano, TipoCampanha campanha);

	Iterable<Campanha> findByAno(String anoPesquisa);
}
