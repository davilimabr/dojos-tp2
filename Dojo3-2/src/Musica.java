public class Musica {
    private String nome;
    private String artista;
    private int duracaoSegundos;

    public Musica(String nome, String artista, int duracao){
        this.nome = nome;
        this.artista = artista;
        this.duracaoSegundos = duracao;
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Musica)) return false;

        Musica musica = (Musica) o;
        return musica.getNome() == this.nome && musica.getArtista() == this.artista && musica.getDuracaoSegundos() == this.duracaoSegundos
    }
}
