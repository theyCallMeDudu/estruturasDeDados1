package trab_04;

public class ABBPalavra extends ABB<Palavra> {
	@Override
	public void inserir(Palavra e) {
		raiz = inserir(raiz, e);
	}
	
	private No inserir(No r, Palavra e) {
		if (r == null)
			r = new No(e);
		else {
			int comparacao = r.item.compareTo(e);
			
			if (comparacao > 0)
				r.esq = inserir(r.esq, e);
			else if (comparacao < 0)
				r.dir = inserir(r.dir, e);
			else
				r.item.ocorrencias++;
		}
		
		return r;
	}
	
	public Palavra maior() {
		return maior(this.raiz);
	}
	
	private Palavra maior(No e) {
		if(e == null) {
			return null;
		}
		else if(e.esq == null && e.dir == null) {
			return e.item;
		}
		else {
			Palavra meio = e.item;
			Palavra maiorEsquerda = maior(e.esq);
			Palavra maiorDireita = maior(e.dir);

			Palavra maior = meio;
			
			if(maiorEsquerda!= null && maiorEsquerda.tamanho() > maior.tamanho()) {
				maior = maiorEsquerda;
			}
			if(maiorDireita != null && maiorDireita.tamanho() > maior.tamanho()) {
				maior = maiorDireita;
			}
			return maior;
		}
		
	}
}
