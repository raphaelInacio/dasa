package com.dasa.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.dasa.domain.Campanha;

@Transactional
public interface CampanhasRepository extends CrudRepository<Campanha, Long> {
	Iterable<Campanha> findByAno(final String ano);
}
