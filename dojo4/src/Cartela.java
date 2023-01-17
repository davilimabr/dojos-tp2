import java.util.*;

public class Cartela {
    private final int TAMANHO_COLUNA = 5;
    private final int TAMANHO_LINHA = 5;
    private final int MAXIMO_SOTEADO = 76;
    private List<List<Integer>> numeros;
    private Set<Integer> numerosMarcados;
    public Cartela(){
        this.numeros = new ArrayList<>();
        this.numerosMarcados = new HashSet<>();

        this.preencher();
    }
    private void preencher(){
        Random aleatorio = new Random();
        for(int i = 0; i < TAMANHO_LINHA; i++){
            List<Integer> coluna = new ArrayList<>();

            for(int j = 0; j < TAMANHO_COLUNA; j++)
                coluna.add(aleatorio.nextInt(MAXIMO_SOTEADO));

            this.numeros.add(coluna);
        }
    }
    private boolean verificaNumeroNaCartela(int numero){
        boolean existe = false;

        for(List<Integer> coluna : this.numeros)
            if(coluna.contains(numero)){
                existe = true;
                break;
            }

        return existe;
    }
    public void marcarNumeroSorteado(int numero) throws Exception{
        if(!this.verificaNumeroNaCartela(numero))
            throw new Exception("Não existe esse número na cartela");

        this.numerosMarcados.add(numero);
    }
}
