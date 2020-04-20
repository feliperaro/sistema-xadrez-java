package xadrez.peças;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Peao extends PecaDeXadrez{

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);
		
		if (getCor() == Cor.BRANCO) {
			p.setValor(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValor(posicao.getLinha() - 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p) && getTabuleiro().posicaoExiste(p2) && !getTabuleiro().temUmaPeca(p2) && getContagemMovimento() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)){
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)){
				mat[p.getLinha()][p.getColuna()] = true;
			}
		}
		else {
			p.setValor(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValor(posicao.getLinha() + 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
			
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p) && getTabuleiro().posicaoExiste(p2) && !getTabuleiro().temUmaPeca(p2) && getContagemMovimento() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValor(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)){
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)){
				mat[p.getLinha()][p.getColuna()] = true;
			}
		}
		return mat;
	}
	
	@Override 
	public String toString() {
		return "P";
	}

}
