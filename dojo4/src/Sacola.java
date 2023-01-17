import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Sacola {
    private final int MAXIMO_NUMEROS = 75;
    private List<Integer> numeros;

    public Sacola(){
        this.numeros = new ArrayList<>();

        this.preencher();
    }

    private void preencher(){
        for(int i = 1; i <= MAXIMO_NUMEROS; i++)
            this.numeros.add(i);
    }

    public int pegarNumero(){
        Random aleatorio = new Random();
        int posicao = aleatorio.nextInt(MAXIMO_NUMEROS);

        return this.numeros.get(posicao);
    }

}
