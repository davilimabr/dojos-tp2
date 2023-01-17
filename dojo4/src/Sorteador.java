import java.util.HashSet;
import java.util.Set;

public class Sorteador {
    private Set<Integer> numerosSorteados;

    public Sorteador(){
        this.numerosSorteados = new HashSet<>();
    }

    public int sortear(Sacola sacola){
        boolean numeroJaSorteado = false;
        int numeroSorteado;
        do{
            numeroSorteado = sacola.pegarNumero();
            numeroJaSorteado = this.numeroJaSorteado(numeroSorteado);
        }while(numeroJaSorteado);

        this.numerosSorteados.add(numeroSorteado);
        return numeroSorteado;
    }

    public boolean numeroJaSorteado(int numero){
        return this.numerosSorteados.contains(numero);
    }
}
