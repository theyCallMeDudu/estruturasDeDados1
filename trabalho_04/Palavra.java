package trab_04;

public class Palavra implements Comparable<Palavra> {
	String texto;
	int ocorrencias = 1;
	
	public Palavra(String texto) {
		super();
		this.texto = texto;
	}

	public int tamanho() {
		return this.texto.length();
	}

	@Override
	public int compareTo(Palavra outraPalavra) {
		return this.texto.compareTo(outraPalavra.texto);
	}
	
	public String toString() {
		return this.texto + ": " + this.ocorrencias + " vezes.";
	}
	
}
