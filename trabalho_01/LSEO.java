package trab_01;

public class LSEO<T extends Comparable<T>> implements IListaOrdenada<T> {

	protected No head;
	protected int qtdItens;
	protected final boolean crescente;
	
	public LSEO(boolean crescente){
		this.crescente = crescente;
	}
	
	protected class No implements Comparable<No> {
		public T item;
		public No prox;
		
		public No(T item) {
			this.item = item;
			this.prox = null;
		}

		@Override
		public int compareTo(No o) {
			return this.item.compareTo(o.item);
		}	
		
	}
	
	public boolean inserir(T e) {		
		 No no = head, ant = null;
		 int resultado = 0;
		 
		 for (no = head; (no != null); no = no.prox){
			 resultado = no.item.compareTo(e);
			 
			 if(!this.crescente) {
				 resultado *= -1;
			 }
			 
			 if (resultado == 0)
				 return false;
			 
			 if (resultado > 0)
				 break;
			 
			 ant = no;
		 }
		 
		 No aux = new No(e);
		 
		 	if (no == head)
		 		head = aux;
		 	else
		 		ant.prox = aux;
		 		aux.prox = no;
		 		qtdItens++;
		 return true;
	}
	
	public boolean estaVazia() {
		return head == null;
	}

	@Override
	public T removerInicio() {
		
		 No no;
	     T item;
	        
	     if (qtdItens == 0) {
	    	 return null;
	     }
	     
        no = head;
        head = head.prox;
		
        item = no.item;
        no.item = null;
        no.prox = null;
        
        qtdItens--;
        
        return item;

	}

	@Override
	public T removerFim() {
        No ultimo, aux;
        T item;
        
        if (qtdItens == 0)
            return null;
        
        if (qtdItens == 1)
            return removerInicio();
        
        // Localiza o antepenultimo no
        aux = localizarNo(qtdItens-2);
        
        // Localiza  ultimo no
        ultimo = aux.prox;
 
        aux.prox = null;
        
        item = ultimo.item;
        ultimo.item = null;
        
        qtdItens--;
        
        return item;

	}

	@Override
	public T removerPosicao(int p) {
		No no, aux;
        T item;
        
        // Checa se a posicao p e valida
        if (p < 0 || p >= qtdItens)
            return null;
        
        // Se p for a 1a posicao, removera do inicio
        // Se p for a ultima, removera do fim
        if (p == 0)
            return removerInicio();
        else if (p == qtdItens-1)
            return removerFim();
        
        // AUX = numero da posicao p-1
        aux = localizarNo(p-1);
        
        no = aux.prox;
        aux.prox = no.prox;
        
        item = no.item;
        no.item = null;
        no.prox = null;
        
        qtdItens--;
        
        return item;
	}
		
	@Override
	public T remover(T e) {
		if (e != null) {
            int p = posicao(e);
            
            if (p != -1) {
                T old = getItem(p);
                
                removerPosicao(p);
                
                return old;
            }
        }
        
		return null;
	}
	
	@Override
	public T getItem(int p) {
		if (p < 0 || p >= qtdItens)
            return null;
        
        return localizarNo(p).item;
	}

	@Override
	public boolean contem(T e) {
		//return posicao(e) != -1;
			 No no;
	
			 for (no = head; ((no != null) && (no.item.compareTo(e) < 0)); no = no.prox);
			 	
			 	if ((no == null) || (no.item.compareTo(e) > 0))
			 		return false;

			 return true;
	}

	@Override
	public int posicao(T e) {
		No aux = head;
        int p = 0;
        
        while (aux != null) {
            if (e.equals(aux.item))
                return p;
            aux = aux.prox;
            p++;
        }
        
        return -1;
	}

	@Override
	public int quantidade() {
		return qtdItens;
	}

	@Override
	public void removerTodos() {
		No aux;
        
        while (head != null) {
            aux = head;
            head = head.prox;
            aux.item = null;
            aux.prox = null;
        }
        
        qtdItens = 0;
	}
	
	public void imprime() { //toString() desta Classe
			No aux;
			
			System.out.println("Elementos da lista:");
			
			for(aux = head; aux != null; aux = aux.prox) {
				System.out.print(aux.item + " ");
			}
			
			System.out.println();
	}

	
	// Metodos auxiliares privados
	private No localizarNo(int p) {
		No aux = head;
        
        while (p > 0) {
            aux = aux.prox;
            p--;
        }
        
        return aux;
	}

}
