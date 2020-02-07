package trab_03;

/**
 * Define as operaÃ§Ãµes bÃ¡sicas da estrutura de dados PILHA
 * @param <T> Tipo a ser armazenado na pilha
 */
public interface IPilha<T> {

    /**
     * Insere o item e no topo da pilha.
     * 
     * @param e Item a ser inserido.
     * @return Verdadeiro, se a operaÃ§Ã£o foi bem sucedida; ou falso, caso contrÃ¡rio.
     */
    public boolean push(T e);

    /**
     * Remove o item do topo da pilha e o retorna.
     * 
     * @return Item do topo da pilha; ou null, se a pilha estiver vazia.
     */
    public T pop();
    
    /**
     * Retorna o item do topo da pilha sem removÃª-lo.
     * 
     * @return Item do topo da pilha; ou null, se a pilha estiver vazia.
     */
    public T peek();
    
    /**
     * Retorna a quantidade de itens da pilha.
     * 
     * @return Quantidade de itens da pilha
     */
    public int quantidade();

    /**
     * Verifica se a pilha estÃ¡ vazia.
     * @return Verdadeiro, se a pilha estiver vazia; ou falso, caso contrÃ¡rio 
     */
    public boolean estaVazia();
    
    /**
     * Remove todos os itens da pilha.
     */
    public void removerTodos();
}
