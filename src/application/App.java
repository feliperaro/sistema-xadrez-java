package application;

import xadrez.PartidaDeXadrez;

public class App {

	public static void main(String[] args) {
		
		PartidaDeXadrez partida = new PartidaDeXadrez();
		UI.printTabuleiro(partida.getPecas());
		

	}

}
