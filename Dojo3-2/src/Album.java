import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Album {
    private String nome;
    private String artista;
    private List<Musica> musicas;

    public Album(String nome, String artista, List<Musica> musicas) {
        this.nome = nome;
        this.artista = artista;
        this.musicas = musicas;
    }

    public Album(String nome, String artista) {
        this.nome = nome;
        this.artista = artista;
        this.musicas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public Musica obterEnesimaMusica(int enesimaMusica){
        try{
            return this.musicas.get(enesimaMusica-1);
        }catch (Exception ex){
            return null;
        }
    }

    public boolean alterarPosicaoMusica(int posicaoInicial, int posicaoDestino){
        try{
            Collections.swap(this.musicas, posicaoInicial, posicaoDestino);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean adicionarMusica(Musica musica){
        boolean ok = this.musicas.add(musica);
        return ok;
    }

    public boolean removerMusica(Musica musica){
        boolean ok = this.musicas.remove(musica);
        return ok;
    }

    public Musica buscaMusicaPorNome(String nome){
        for(Musica musica : this.musicas)
            if(musica.getNome().equals(nome))
                return musica;

        return null;
    }

    @Override
    public String toString(){
        String string = String.format("Nome: %s\nArtista: %s", this.nome, this.artista);
        string += "\nMusicas:\n";

        for(int i = 0; i < this.musicas.size(); i++)
            string += String.format("%d. Nome: %s\n", i+1, this.musicas.get(i).getNome());

        return string;
    }
}
