import java.util.Collections;
import java.util.List;

public class Album {
    private String nome;
    private String artista;
    private int quantidadeMusicas;
    private List<Musica> musicas;

    public Album(){

    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public int getQuantidadeMusicas() {
        return quantidadeMusicas;
    }

    private void defineQuantidadeMusicas(){
        this.quantidadeMusicas = this.musicas.size();
    }

    public Musica obterEnesimaMusica(int enesimaMusica){
        try{
            return this.musicas.get(enesimaMusica-1);
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public String toString(){
        String string = String.format("Nome: %s\nArtista: %s", this.nome, this.artista);
        string += "\nMusicas:\n";

        for(int i = 0; i < this.musicas.size(); i++)
            string += String.format("%d. Nome: %s", i+1, this.musicas.get(i).getNome());

        return string;
    }

    public boolean alterarPosicaoMusica(int posicaoInicial, int posicaoDestino){
        try{
            Collections.swap(this.musicas, posicaoInicial, posicaoDestino);
            return true;
        }catch (Exception ex){
            return false
        }
    }

    public boolean adicionarMusica(Musica musica){
        boolean ok = this.musicas.add(musica);
        defineQuantidadeMusicas();
        return ok;
    }

    public boolean removerMusica(Musica musica){
        boolean ok = this.musicas.remove(musica);
        defineQuantidadeMusicas();
        return ok;
    }

    public Musica buscaMusicaPorNome(String nome){
        for(Musica musica : this.musicas)
            if(musica.getNome() == nome)
                return musica;

        return null;
    }
}
