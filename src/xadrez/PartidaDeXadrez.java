package xadrez;

import tabuleiro.Tabuleiro;
import xadrez.peças.Rei;
import xadrez.peças.Torre;

public class PartidaDeXadrez {
	 
	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		this.tabuleiro = new Tabuleiro(8, 8);
		setupInicial();
	}
	
	public PecaDeXadrez[][] getPecas() {
		 PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		 
		 for (int i = 0; i < tabuleiro.getLinhas(); i ++) {
			 for (int j = 0; j < tabuleiro.getColunas(); j ++) {
				 mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			 }
		 }
		 
		 return mat;
	}
	
	private void lugarNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void setupInicial() {
		lugarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
        lugarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
        lugarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
        lugarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
        lugarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
        lugarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

        lugarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
        lugarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
        lugarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
        lugarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
        lugarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
        lugarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}

}
