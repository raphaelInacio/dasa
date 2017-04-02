package com.dasa.domain;

import lombok.Data;

@Data
public class ParticipacaoCampanha {

	private Long participantes;
	private TipoCampanha campanha;

	public Long getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Long participantes) {
		this.participantes = participantes;
	}

	public TipoCampanha getCampanha() {
		return campanha;
	}

	public void setCampanha(TipoCampanha campanha) {
		this.campanha = campanha;
	}

	public ParticipacaoCampanha(TipoCampanha campanha, Long participantes) {
		this.campanha = campanha;
		this.participantes = participantes;
	}
}
