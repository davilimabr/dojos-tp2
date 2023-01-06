import java.util.*;

public class Livro {
    private String id;
    private String nome;
    private String autor;
    private String editora;
    private Date publicacao;
    private List<Aluguel> alugueis;

    public Livro(String id, String nome, String autor, String editora, Date publicacao){
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.publicacao = publicacao;
        this.alugueis = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public Date getPublicacao() {
        return publicacao;
    }

    public void registrarAluguel(Aluguel aluguel){
        if(!this.alugueis.contains(aluguel))
            this.alugueis.add(aluguel);
    }

    public void devolver(){
        this.obterUltimoAluguel().encerrar();
    }

    public boolean estaALugado(){
        if(this.alugueis.isEmpty())
            return false;

        return this.obterUltimoAluguel().estaAtivo();
    }

    private Aluguel obterUltimoAluguel(){
        int ultimaPosicao = this.alugueis.size() > 0 ? this.alugueis.size() -1: 0;
        return this.alugueis.get(ultimaPosicao);
    }

    public String obterRelatorioAlugueis(){
        StringBuilder relatorio = new StringBuilder(String.format("Alugueis do livro: %s\n", this.toString()));

        for(Aluguel aluguel : this.alugueis){
            String relatorioAluguel = aluguel.getCliente().toString();

            Date dataAluguel = aluguel.getDataAluguel();
            Date dataDevolucao = aluguel.getDataDevolucao();

            String textoDataDevolucao = dataDevolucao == null ? "" :dataDevolucao.toString();

            relatorioAluguel += String.format("  Data aluguel: %s  |  Data devolução: %s", dataAluguel.toString(),
                    textoDataDevolucao);

            relatorio.append(relatorioAluguel);
        }
        return relatorio.toString();
    }

    @Override
    public String toString(){
        return String.format("id: %s  |  nome: %s  |  autor: %s  |  editora: %s  |  publicação: %s",
                this.id, this.nome, this.autor, this.editora, this.publicacao.toString());
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;

        return ((Livro) o).getId() == this.getId();
    }
}
