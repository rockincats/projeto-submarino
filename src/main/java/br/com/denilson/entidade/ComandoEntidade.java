package br.com.denilson.entidade;

public class ComandoEntidade {

	private int eixoX;
	private int eixoY;
	private int eixoZ;
	private String posicao;

	public ComandoEntidade(){
		this.eixoX = 0;
		this.eixoY = 0;
		this.eixoZ = 0;
		this.posicao = "NORTE";	
	}
	
	public ComandoEntidade(String posicao){
		this.eixoX = 0;
		this.eixoY = 0;
		this.eixoZ = 0;
		this.posicao = posicao;	
	}
	
	public int getEixoX() {
		return eixoX;
	}

	public void setEixoX(int eixoX) {
		this.eixoX = eixoX;
	}

	public int getEixoY() {
		return eixoY;
	}

	public void setEixoY(int eixoY) {
		this.eixoY = eixoY;
	}

	public int getEixoZ() {
		return eixoZ;
	}

	public void setEixoZ(int eixoZ) {
		this.eixoZ = eixoZ;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

}
