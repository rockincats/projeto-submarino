package br.com.denilson.constantes;

public enum Orientacao {
	NORTE(0, "NORTE"), 
	LESTE(1, "LESTE"), 
	SUL(2, "SUL"), 
	OESTE(3, "OESTE");

	private Integer index;
	private String descricao;

	Orientacao(int index, String descricao) {
		this.index = index;
		this.descricao = descricao;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public static Orientacao getByDescricao(String descricao) {
		if (descricao == null)
			return null;
		for (Orientacao e : Orientacao.values()) {
			if (e.descricao.equals(descricao))
				return e;
		}
		return null;
	}
	
	public static Orientacao getByCode(Integer code) {
		if (code == null)
			return null;
		for (Orientacao e : Orientacao.values()) {
			if (e.index.equals(code))
				return e;
		}
		return null;
	}
	
}
