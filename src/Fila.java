import java.util.NoSuchElementException;

public class Fila<E> {
    
    private Celula<E> inicio;
    private Celula<E> fim;

    
    public Fila(){

        Celula<E> sentinela = new Celula<E>();
        inicio = sentinela;
        fim = sentinela;

    }

    public Fila(E dado){

        Celula<E> sentinela = new Celula<E>();
        inicio = sentinela;

        Celula<E> c = new Celula<E>(dado);
        fim = c;
        fim.setProximo(null);
        sentinela.setProximo(c);

    }

    public boolean filaVazia(){
        return inicio == fim;
    }

    public void inserir(E dado){
        
        Celula<E> c = new Celula<E>(dado);

        c.setProximo(null);
        fim.setProximo(c);
        fim = c;
        
    }

    public E retirar(){
        
        Celula<E> c = new Celula<E>(inicio.getProximo().getItem());
        inicio.setProximo(c.getProximo());

        return c.getItem();
    }
}
