package com.dasa.domain;

public enum TipoCampanha {

	MAMA("Câncer de Mama"), PROSTATA("Câncer de Próstata");
	
	private String tipo;

	private TipoCampanha(String tipo) {
		this.setTipo(tipo);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
