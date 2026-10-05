import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;
	private int tamanho;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
		tamanho ++;
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		tamanho --;
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	/**
	 * Cria e devolve uma nova pilha contendo os primeiros numItens elementos
	 * do topo da pilha atual.
	 * 
	 * Os elementos são mantidos na mesma ordem em que estavam na pilha original.
	 * Caso a pilha atual possua menos elementos do que o valor especificado,
	 * uma exceção será lançada.
	 *
	 * @param numItens o número de itens a serem copiados da pilha original.
	 * @return uma nova instância de Pilha<E> contendo os numItens primeiros elementos.
	 * @throws IllegalArgumentException se a pilha não contém numItens elementos.
	 */
	public Pilha<E> subPilha(int numItens) {
		
		if(numItens > tamanho){
			throw new IllegalArgumentException("o valor solicitado é maior que o numero de itens");
		}else{

			Pilha<E> pilhaAux = new Pilha<>();
			Pilha<E> pilhaFinal = new Pilha<>();

			for (int i = 0; i < numItens; i++ ){
				pilhaAux.empilhar(desempilhar());
			}

			while (!pilhaAux.vazia()) {
				
				E dado;

				dado = pilhaAux.desempilhar();

				pilhaFinal.empilhar(dado);
				empilhar(dado);

			}
			
			return pilhaFinal;
		}
	}
}