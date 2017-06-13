package br.com.denilson.app;

import java.util.Scanner;

import br.com.denilson.entidade.ComandoEntidade;
import br.com.denilson.regras.ProcessamentoCoordenadas;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Entre com a sequencia de comandos: ");
		String data = input.next();

		ProcessamentoCoordenadas regrasCoordenadas = new ProcessamentoCoordenadas();
		ComandoEntidade comandos = regrasCoordenadas.processarPosicao(data);

		System.out.println("Entrada: " + data);

		System.out.println("Saida: (" + comandos.getEixoX() + "," + 
		                                comandos.getEixoY() + "," + 
				                        comandos.getEixoZ() + "," + 
		                                comandos.getPosicao() + ")");

	}

}
