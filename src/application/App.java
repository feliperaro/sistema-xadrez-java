package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.ChessException;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoXadrez;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partida = new PartidaDeXadrez();
		List<PecaDeXadrez> capturada = new ArrayList<>();
		
		while(!partida.getCheckMate()) {
			try {
				UI.clearScreen();
				
				UI.printPartida(partida, capturada);
				
				System.out.println();
				
				System.out.println("Q = Rainha\nK = Rei\nT = Torre\nC = Cavalo\nB = Bispo\nP = Peao");
				
				System.out.println();
				
				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.lePosicaoXadrez(sc);
				
				boolean [][] possiveisMovimentos = partida.possiveisMovimentos(origem);
				UI.clearScreen();
				UI.printTabuleiro(partida.getPecas(), possiveisMovimentos);
				
				System.out.println();
				
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.lePosicaoXadrez(sc);
				
				PecaDeXadrez pecaCapturada = partida.executaMovimentoDeXadrez(origem, destino);
				
				if (pecaCapturada != null) {
					capturada.add(pecaCapturada);
				}
				
				if (partida.getPromovido() != null) {
					System.out.println("Entre com a peca para ser promovida (B/C/T/Q)");
					String tipo = sc.nextLine().toUpperCase();
					partida.trocaPecaPromovida(tipo);
				}
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printPartida(partida, capturada);
	}
}
