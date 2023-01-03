import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner teclado = new Scanner(System.in);
    private List<Album> albuns;

    public Menu(){
        this.albuns = new ArrayList<Album>();
    }

    public void mostrarMenuPrincipal(){
        try{
            Album albumEscolhido = this.albuns.get(mostrarMenuEscolhaAlbum()-1);
            mostrarMenuAlteracaoDeAlbuns(albumEscolhido);
        }catch (Exception ex){
            this.imprimir(ex.getMessage());
        }
    }
    private int mostrarMenuEscolhaAlbum() throws Exception{
        if(this.albuns.isEmpty()){
            this.imprimir("Nenhum album existente");
            throw new Exception("Nenhum album existente");
        }

        int opcao = 0;
        while(opcao < 0 || opcao > this.albuns.size()){
            for(int i = 0; i < this.albuns.size(); i++){
                this.imprimir(String.format("%d. Nome: %s",i+1, this.albuns.get(i).getNome()));
            }

            this.imprimir("\nEscolha o album:");
            opcao = teclado.nextInt();
            return opcao;
        }
        throw new Exception("Album inválido");
    }

    private void mostrarMenuAlteracaoDeAlbuns(Album album){
        int opcao = 0;
        while(opcao < 7){
            this.imprimir("(1) Adicionar musica");
            this.imprimir("(2) Remover musica");
            this.imprimir("(3) Checar se uma musica esta no album");
            this.imprimir("(4) Verificar nome da e-nesima musica");
            this.imprimir("(5) Imprimir dados do album");
            this.imprimir("(6) Alterar posicao de uma musica na lista");
            this.imprimir("(7) Sair");

            opcao = teclado.nextInt();

            switch (opcao){
                case 1 -> menuAdicionarMusica(album);
                case 2 -> menuRemoverMusica(album);
                case 3 -> menuChecarMusica(album);
                case 4 -> menuVerificarEnesimaMusica(album);
                case 5 -> menuImprimirAlbum(album);
                case 6 -> menuAlterarPosicaoMusica(album);
            }
        }
    }

    private void menuAdicionarMusica(Album album){
        this.imprimir("Digite o nome, artista e duracao da musica");

        String nome = teclado.nextLine();
        String artista = teclado.nextLine();
        int duracao = teclado.nextInt();

        Musica novaMusica = new Musica(nome, artista, duracao);

        this.imprimeSucessoOuErro(album.adicionarMusica(novaMusica));
    }

    private void menuRemoverMusica(Album album){
        this.imprimir("Digite o nome da musica que deseja excluir");

        String nome = teclado.nextLine();
        Musica musica = album.buscaMusicaPorNome(nome);

        this.imprimeSucessoOuErro(album.removerMusica(musica));
    }

    private void menuChecarMusica(Album album){
        this.imprimir("Digite o nome da musica");

        String nome = teclado.nextLine();

        boolean existe = album.buscaMusicaPorNome(nome) != null ? true : false;

        this.imprimeSucessoOuErro(existe);
    }

    private void menuVerificarEnesimaMusica(Album album){
        this.imprimir("Escolha a posicao da musica que deseja saber o nome");

        int posicao = teclado.nextInt();

        Musica musica = album.obterEnesimaMusica(posicao);

        boolean ok = musica != null ? true : false;

        this.imprimeSucessoOuErro(ok);
        this.imprimir(musica.getNome());
    }

    private void menuImprimirAlbum(Album album){
        this.imprimir(album.toString());
    }

    private void menuAlterarPosicaoMusica(Album album){
        this.imprimir("Digite a posicao da musica que deve ser alterada e a sua nova posicao");

        int posicaoOrigem = teclado.nextInt();
        int posicaoDestino = teclado.nextInt();

        this.imprimeSucessoOuErro(album.alterarPosicaoMusica(posicaoOrigem, posicaoDestino));
    }

    public void imprimeSucessoOuErro(boolean operacao){
        if(operacao)
            this.imprimir("Operacao realizada com sucesso");
        else
            this.imprimir("Erro ao realizar operacao");
    }

    public void imprimir(String string){
        System.out.println(string);
    }
}
