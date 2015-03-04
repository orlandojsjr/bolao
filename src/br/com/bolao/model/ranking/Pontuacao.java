package br.com.bolao.model.ranking;


public class Pontuacao {
	
	public int acertoVencedorCabeca;
	public int acertoPlacarVencedor;
	public int acertoVencedor;
	
	public int getGeral() {
		return acertoVencedorCabeca + acertoPlacarVencedor + acertoVencedor;
	}
	
	public int getAcertoVencedorCabeca() {
		return acertoVencedorCabeca;
	}
	public void setAcertoVencedorCabeca(int acertoVencedorCabeca) {
		this.acertoVencedorCabeca = acertoVencedorCabeca;
	}
	public int getAcertoPlacarVencedor() {
		return acertoPlacarVencedor;
	}
	public void setAcertoPlacarVencedor(int acertoPlacarVencedor) {
		this.acertoPlacarVencedor = acertoPlacarVencedor;
	}
	public int getAcertoVencedor() {
		return acertoVencedor;
	}
	public void setAcertoVencedor(int acertoVencedor) {
		this.acertoVencedor = acertoVencedor;
	}
}