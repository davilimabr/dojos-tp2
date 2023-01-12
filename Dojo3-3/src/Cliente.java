import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente{
    private String nome;
    private String cpf;

    private List<Aluguel> alugueis;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.alugueis = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean possuiMaisQueDoisAlugueisAtivos(){
        int contador = 0;
        for(Aluguel aluguel : this.alugueis)
            if(aluguel.estaAtivo())
                contador++;

        return contador >= 2;
    }

    public boolean livroAlugadoUltimosTresAlugueis(Livro livro){
        for(int i = this.alugueis.size(); i > this.alugueis.size() - 3; i--){
            if(this.alugueis.size() < 3)
                return false;
            if(this.alugueis.get(i).getLivro().equals(livro))
                return true;
        }
        return false;
    }

    public void registrarAluguel(Aluguel aluguel){
        if(!this.alugueis.contains(aluguel))
            this.alugueis.add(aluguel);
    }

    public String obterRelatorioAlugueis(){
        StringBuilder relatorio = new StringBuilder(String.format("Alugueis realizados por: %s\n", this));

        for(Aluguel aluguel : this.alugueis){
            String relatorioAluguel = aluguel.getLivro().toString();

            Date dataAluguel = aluguel.getDataAluguel();
            Date dataDevolucao = aluguel.getDataDevolucao();

            String textoDataDevolucao = dataDevolucao == null ? "" :dataDevolucao.toString();

            relatorioAluguel += String.format("  Data aluguel: %s  |  Data devolução: %s\n", dataAluguel.toString(),
                    textoDataDevolucao);

            relatorio.append(relatorioAluguel);
        }
        return relatorio.toString();
    }

    @Override
    public String toString(){
        return String.format("Nome: %s  |  CPF: %s", this.nome, this.cpf);
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Cliente)) return false;

        return ((Cliente) o).getCpf().equals(this.cpf);
    }
}
