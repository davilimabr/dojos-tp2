public class Prova {
    private Prova.Tipo tipo;
    private double nota;
    private String conteudo;

    public Prova(Tipo tipo, double nota, String conteudo){
        this.tipo = tipo;
        this.nota = nota;
        this. conteudo = conteudo;
    }
    public Tipo getTipo() {
        return tipo;
    }

    public double getNota() {
        return nota;
    }

    public String getConteudo() {
        return conteudo;
    }

    public enum Tipo{
        Avaliacao1, Avaliacao2, ProvaFinal
    }
}
