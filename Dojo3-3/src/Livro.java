import java.util.Calendar;

public class Livro {
    private String nome;
    private String autor;
    private String editora;
    private Calendar publicacao;

    public Livro(String nome, String autor, String editora, Calendar publicacao){
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.publicacao = publicacao;
    }

    public Livro(Livro livro){
        this.nome = livro.getNome();
        this.autor = livro.getAutor();
        this.editora = livro.getEditora();
        this.publicacao = livro.getPublicacao();
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

    public Calendar getPublicacao() {
        return (Calendar) publicacao.clone();
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Livro)) return false;

        return ((Livro) o).getNome().equals(this.nome);
    }
}
