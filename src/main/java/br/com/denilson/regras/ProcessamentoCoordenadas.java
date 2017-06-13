package br.com.denilson.regras;

import java.util.ArrayList;
import java.util.List;

import br.com.denilson.constantes.Orientacao;
import br.com.denilson.entidade.ComandoEntidade;

public class ProcessamentoCoordenadas {
		
	private final char LEFT = 'L';
	private final char RIGHT = 'R';
	private final char UP = 'U';
	private final char DOWN = 'D';
	private final char MOVE = 'M';
	
	
	public ComandoEntidade processarPosicao(String comandos){
		List<ComandoEntidade> instrucoesProcessadas = new ArrayList<ComandoEntidade>();
		ComandoEntidade resultadoFinal = new ComandoEntidade();  
		
		
	    char arr[] = comandos.toCharArray();
	    for (char c : arr){
	    	instrucoesProcessadas.add(this.decodificar(c, instrucoesProcessadas));
	    }
		
		resultadoFinal = this.processarResultado(instrucoesProcessadas);
		
		return resultadoFinal;						
	}


	private ComandoEntidade processarResultado(List<ComandoEntidade> lstComandosProcessados) {
		ComandoEntidade resultado = new ComandoEntidade(this.recuperarSerieAnterior(lstComandosProcessados).getPosicao());
		for (ComandoEntidade comando : lstComandosProcessados) {
			int somaEixoX = resultado.getEixoX() + comando.getEixoX();
			int somaEixoY = resultado.getEixoY() + comando.getEixoY();
			int somaEixoZ = resultado.getEixoZ() + comando.getEixoZ();
						
			resultado.setEixoX(somaEixoX);
			resultado.setEixoY(somaEixoY);
			resultado.setEixoZ(somaEixoZ);					
		}
				
		return resultado;
	}


	private ComandoEntidade decodificar(char comando, List<ComandoEntidade> lstComandos) {
		ComandoEntidade serie = null;
		ComandoEntidade serieAnterior = this.recuperarSerieAnterior(lstComandos);
		
		switch (comando){
		case RIGHT:
			serie = this.processarDireita(serieAnterior);
			break;
		case LEFT:
			serie = this.processarEsquerda(serieAnterior);
			break;
		case UP:
			serie = this.processarAcima(serieAnterior);
			break;
		case DOWN:
			serie = this.processarAbaixo(serieAnterior);
			break;
		case MOVE:
			serie = this.processarMovimentacao(serieAnterior);
			break;
		}

		return serie;
	}


	private ComandoEntidade recuperarSerieAnterior(List<ComandoEntidade> lstComandos) {
		if(lstComandos.size() > 0){
			return lstComandos.get(lstComandos.size()-1);	
		}else{
			return new ComandoEntidade();
		}
		
	}


	private ComandoEntidade processarMovimentacao(ComandoEntidade serieAnterior) {
		ComandoEntidade comando = new ComandoEntidade(serieAnterior.getPosicao());	
				
		switch (serieAnterior.getPosicao()) {
		case "NORTE":
			comando.setEixoY(1);
			break;
		case "LESTE":
			comando.setEixoX(1);
			break;
		case "SUL":
			break;
		case "OESTE":
			break;
		}
		
		return comando;
	}


	private ComandoEntidade processarAbaixo(ComandoEntidade serieAnterior) {
		ComandoEntidade comando = new ComandoEntidade(serieAnterior.getPosicao());						
		comando.setEixoZ(-1);
		return comando;		
	}


	private ComandoEntidade processarAcima(ComandoEntidade serieAnterior) {
		ComandoEntidade comando = new ComandoEntidade(serieAnterior.getPosicao());	
	
		return comando;		
	}


	private ComandoEntidade processarEsquerda(ComandoEntidade serieAnterior) {
		Integer valor = Orientacao.getByDescricao(serieAnterior.getPosicao()).getIndex();
		
		if(valor > Orientacao.NORTE.getIndex()){
			valor = valor - 1;
		}else{
			valor = Orientacao.OESTE.getIndex();
		}
		
		ComandoEntidade comando = new ComandoEntidade(Orientacao.getByCode(valor).getDescricao());	
		
		return comando;		
	}


	private ComandoEntidade processarDireita(ComandoEntidade serieAnterior) {
		Integer valor = Orientacao.getByDescricao(serieAnterior.getPosicao()).getIndex();
		
		if(valor == Orientacao.OESTE.getIndex()){
			valor = 0;
		}else{
			valor = valor + 1;
		}
		
		ComandoEntidade comando = new ComandoEntidade(Orientacao.getByCode(valor).getDescricao());	
		
		return comando;		
	}	
}
