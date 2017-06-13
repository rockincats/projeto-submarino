package br.com.denilson.teste;

import org.junit.Test;

import br.com.denilson.constantes.Orientacao;
import br.com.denilson.entidade.ComandoEntidade;
import br.com.denilson.regras.ProcessamentoCoordenadas;
import junit.framework.TestCase;

public class TesteEntrada extends TestCase{

	@Test
	public void testEntradaNorte() {		
		ProcessamentoCoordenadas regrasCoordenadas = new ProcessamentoCoordenadas();
		ComandoEntidade comandos = regrasCoordenadas.processarPosicao("M");
		
		assertEquals(Orientacao.NORTE.getDescricao(), comandos.getPosicao());
		assertEquals(0, comandos.getEixoX());
		assertEquals(1, comandos.getEixoY());
		assertEquals(0, comandos.getEixoZ());
	}
	
	@Test
	public void testEntradaLeste() {		
		ProcessamentoCoordenadas regrasCoordenadas = new ProcessamentoCoordenadas();
		ComandoEntidade comandos = regrasCoordenadas.processarPosicao("RM");
		
		assertEquals(Orientacao.LESTE.getDescricao(), comandos.getPosicao());
		assertEquals(1, comandos.getEixoX());
		assertEquals(0, comandos.getEixoY());
		assertEquals(0, comandos.getEixoZ());
	}
	
	@Test
	public void testEntradaParaBaixo() {		
		ProcessamentoCoordenadas regrasCoordenadas = new ProcessamentoCoordenadas();
		ComandoEntidade comandos = regrasCoordenadas.processarPosicao("D");
		
		assertEquals(Orientacao.NORTE.getDescricao(), comandos.getPosicao());
		assertEquals(0, comandos.getEixoX());
		assertEquals(0, comandos.getEixoY());
		assertEquals(-1, comandos.getEixoZ());
	}
	
	@Test
	public void testTatalizacao() {		
		ProcessamentoCoordenadas regrasCoordenadas = new ProcessamentoCoordenadas();
		ComandoEntidade comandos = regrasCoordenadas.processarPosicao("MMRMMDD");
		
		assertEquals(Orientacao.LESTE.getDescricao(), comandos.getPosicao());
		assertEquals(2, comandos.getEixoX());
		assertEquals(2, comandos.getEixoY());
		assertEquals(-2, comandos.getEixoZ());
	}

}
