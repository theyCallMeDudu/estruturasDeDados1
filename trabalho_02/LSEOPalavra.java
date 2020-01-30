package trab_02;

import trab_02.LSEO.No;

public class LSEOPalavra extends LSEO<Palavra> {

	public LSEOPalavra(boolean crescente) {
		super(crescente);
	}
	
	public boolean inserir(Palavra palavra) {		
		 No no = head, ant = null;
		 int resultado = 0;
		 
		 for (no = head; (no != null); no = no.prox){
			 resultado = no.item.compareTo(palavra);
			 
			 if(!this.crescente) {
				 resultado *= -1;
			 }
			 
			 if (resultado == 0) {
				 no.item.ocorrencias++;
				 return false;
			 }
				 
			 
			 if (resultado > 0)
				 break;
			 
			 ant = no;
		 }
		 
		 No aux = new No(palavra);
		 
		 	if (no == head)
		 		head = aux;
		 	else
		 		ant.prox = aux;
		 		aux.prox = no;
		 		qtdItens++;
		 return true;
	}
	
	public Palavra retornaMaior() {
		No atual, maior;
		atual = head;
		maior = atual;
		
		while(atual != null) {
			if(maior.item.tamanho() < atual.item.tamanho()) {
				maior = atual;
			}
			atual = atual.prox;
		}
		return maior.item;		
	}

}
