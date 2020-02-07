package trab_03;

/**
 * Implementa a estrutura de dados PILHA usando uma Lista Simplesmente Encadeada
 * @param <T> Tipo a ser armazenado na pilha
 */
public class Pilha<T> implements IPilha<T> {
    
	protected No  topo;
	protected int qtdItens;

	protected class No {
        public T  item;
        public No prox;

        public No(T item) {
            this.item = item;
            this.prox = null;
        }
    }
        
    @Override
    public boolean push(T e) {
        No no;
        
        try {
            no = new No(e);
        }
        catch(OutOfMemoryError ex) {
            return false;
        }
        
        no.prox = topo;
        topo = no;
        
        qtdItens++;
        
        return true;
    }

    @Override
    public T pop() {
        No aux;
        T item;
        
        if (qtdItens == 0)
            return null;
        
        aux = topo;
        topo = topo.prox;
        
        item = aux.item;
        aux.item = null;
        aux.prox = null;
        
        qtdItens--;
        
        return item;
    }

    @Override
    public T peek() {
        if (qtdItens == 0)
            return null;

        return topo.item;
    }

    @Override
    public int quantidade() {
        return qtdItens;
    }

    @Override
    public boolean estaVazia() {
        return qtdItens == 0;
    }

    @Override
    public void removerTodos() {
        No aux;
        
        while (topo != null) {
            aux = topo;
            topo = topo.prox;
            aux.item = null;
            aux.prox = null;
        }
        
        qtdItens = 0;
    }
    
    /**
     * Retorna uma string com os itens da pilha no formato [e1, e2, e3, ..., en].
     */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        
        buffer.append("[");
        
        if (topo != null) {
            No aux = topo;
            
            while (aux.prox != null) {
                buffer.append(aux.item);
                buffer.append(", ");
                aux = aux.prox;
            }

            buffer.append(aux.item);
        }
        
        buffer.append("]");
        
        return buffer.toString();
    }
}
