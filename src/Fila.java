import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

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

    public boolean vazia(){
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

    public E espiar(){

        if (vazia()) {
            throw new NoSuchElementException("Nao há nenhum item na fila!");
        }else{

            Celula<E> c = new Celula<E>(inicio.getProximo().getItem());

            return c.getItem();
        }
    }

    public double calcularValorMedio( Function<E, Double> extrator, int quantidade){
        
        double valorTotal = 0, media = 0;
        Celula<E> c = inicio.getProximo();
        int num = 0;
            
        if(quantidade <= 0){

            throw new NoSuchElementException("Não foi solicitado nenhum item!");

        }else{
            if(vazia()){

                throw new NoSuchElementException("Nao há nenhum item na fila!");

            }else{

                for(int i = 0; i < quantidade && c != null; i++){

                    E dadoAtual = c.getItem();

                    valorTotal += extrator.apply(dadoAtual);

                    num += 1;

                    c = c.getProximo();
                }

                media = valorTotal / num;
            }
        }

        return media;
    }

    public Fila<E> filtrar(Predicate<E> condicional, int quantidade){

        Fila<E> filtro = new Fila<E>();
        Celula<E> c = inicio.getProximo();
        
        if(quantidade <= 0){

            throw new NoSuchElementException("Não foi solicitado nenhum item!");

        }else{
            if(vazia()){

                throw new NoSuchElementException("Nao há nenhum item na fila!");

            }else{
                for (int i = 0; i < quantidade && c != null; i++) {

                    if (condicional.test(c.getItem())) {
                        filtro.inserir(c.getItem());
                    }

                    c = c.getProximo();
                }
            }
        }

        return filtro;

    }
}
