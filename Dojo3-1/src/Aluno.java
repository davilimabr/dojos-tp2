import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private int matricula;
    private String nome;
    private int idade;
    private List<Prova> avaliacoes;
    private double media;
    private Aluno.Situacao situacao;

    public Aluno(int matricula, String nome, int idade){
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.avaliacoes = new ArrayList<Prova>();
    }

    public int getMatricula(){
        return this.matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getMedia() {
        return media;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void adicionarAvaliacao(Prova prova){
        this.avaliacoes.add(prova);
        calcularMediaAvaliacoes();
        calcularSituacaoAluno();
    }

    private void calcularMediaAvaliacoes(){
        double somaNotas = 0;
        for(Prova prova : this.avaliacoes){
            somaNotas += prova.getNota();
        }

        this.media = somaNotas/this.avaliacoes.size();
    }

    private void calcularSituacaoAluno(){
        if(this.media >= 7)
            this.situacao = Situacao.Aprovado;
        else if(this.media >= 5)
            this.situacao = Situacao.ProvaFinal;
        else
            this.situacao = Situacao.Reprovado;
    }

    @Override
    public String toString(){
        String string = String.format("Matricula: %d  Nome: %s  Idade: %d ",this.matricula, this.nome, this.idade);
        string += "\nProvas\n";

        for(Prova prova : this.avaliacoes)
            string += String.format("Tipo: %s  Nota: %.2f\n", prova.getTipo().toString(), prova.getNota());

        return string;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Aluno)) return false;

        return ((Aluno) o).getMatricula() == this.matricula;
    }
    public enum Situacao{
        Aprovado, ProvaFinal, Reprovado
    }

}
