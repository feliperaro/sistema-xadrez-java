package application;

import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoXadrez;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partida = new PartidaDeXadrez();
		
		while(true) {
			UI.printTabuleiro(partida.getPecas());
			
			System.out.println();
			
			System.out.print("Origem: ");
			PosicaoXadrez origem = UI.lePosicaoXadrez(sc);
			
			System.out.println();
			
			System.out.print("Destino: ");
			PosicaoXadrez destino = UI.lePosicaoXadrez(sc);
			
			PecaDeXadrez pecaCapturada = partida.movePeca(origem, destino); 
			
		}

	}

}
