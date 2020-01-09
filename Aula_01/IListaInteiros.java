package exerc_aulas;

public interface IListaInteiros {
	
	// Define os números e suas posições
	public void inserirInicio(Integer num);
	public void inserirFim(Integer num);
	public void inserirPosicao(Integer num, Integer p);
	
	// Altera a posição de um número
	public void alterar(Integer p, Integer num);
	
	// Remove números e posições
	public void removerInicio();
	public void removerFim();
	public void removerPosicao(Integer p);
	public void remover(Integer num);
	
	// Retorna números e posições
	public Integer getNumero(Integer p);
	public Integer posicao(Integer num); 
	
	// Verifica possíveis estados da lista
	public boolean pertence(Integer num);
	public boolean estaVazia();
	
	// Retorna a quantidade de intens da lista
	public Integer quantidade();
	
	// Esvazia a lista
	public void removerTodos();
}
