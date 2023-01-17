import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private final int NUMERO_MAX_CARTELAS = 4;
    private String cpf;
    private String nome;

    private List<Cartela> cartelas;

    public Jogador(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;

        this.cartelas = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void pegarCartela() throws Exception{
        if(this.cartelas.size() > NUMERO_MAX_CARTELAS)
            throw new Exception("Numero maximo de cartelas excedido");

        this.cartelas.add(new Cartela());
    }

    public void marcarNumeroNaCartela(int numero) throws Exception {
        boolean naoExisteEmNenhumaCartela = false;
        for(Cartela cartela : this.cartelas){
            try{
                cartela.marcarNumeroSorteado(numero);
                naoExisteEmNenhumaCartela = true;
            }catch (Exception ex){
                continue;
            }
        }
        if(naoExisteEmNenhumaCartela)
            throw new Exception("Esse número não está presente em nenhuma das cartelas do jogador");
    }

}
