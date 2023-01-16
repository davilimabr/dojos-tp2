import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner teclado;
    private final List<Album> albuns;

    public Menu(){
        this.albuns = new ArrayList<Album>();
        this.teclado = new Scanner(System.in);
    }

    public void exibirMenuPrincipal(){
        boolean continua = true;
        while(continua){
            try{
                int opcao = this.exibirMenuEscolhaCriarOuManipular();

                if(opcao == 1)
                    this.menuCriarNovoAlbum();
                else{
                    Album albumEscolhido = this.albuns.get(mostrarMenuEscolhaAlbum()-1);
                    mostrarMenuAlteracaoDeAlbuns(albumEscolhido);
                }
            }catch (Exception ex){
                this.imprimir(ex.getMessage());
            }

            this.imprimir("Continua? 1 - sim  2 - nao");
            int opcao = teclado.nextInt();
            if(opcao == 2)
                continua = false;
        }
    }

    private int exibirMenuEscolhaCriarOuManipular(){
        int opcao = 0;
        while(opcao <= 0 || opcao > 2){
            this.imprimir("""
                    Deseja:
                    (1) Criar novo album
                    (2) Manipular album existente
                    """);

            opcao = teclado.nextInt();
        }
        return opcao;
    }

    private void menuCriarNovoAlbum(){
        this.imprimir("Digite o nome do album e do artista");

        teclado.nextLine();
        String nomeAlbum = teclado.nextLine();
        String nomeArtista = teclado.nextLine();
        List<Musica> musicas = this.lerMusicas();

        Album novoAlbum = new Album(nomeAlbum, nomeArtista, musicas);

        this.imprimeSucessoOuErro(this.albuns.add(novoAlbum));
    }

    private int mostrarMenuEscolhaAlbum() throws Exception{
        if(this.albuns.isEmpty())
            throw new Exception("Nenhum album existente");

        int opcao = 0;
        while(opcao <= 0 || opcao > this.albuns.size()){
            for(int i = 0; i < this.albuns.size(); i++)
                this.imprimir(String.format("%d. Nome: %s",i+1, this.albuns.get(i).getNome()));

            this.imprimir("\nEscolha o album:");
            opcao = teclado.nextInt();
        }
        return opcao;
    }

    private void mostrarMenuAlteracaoDeAlbuns(Album album){
        int opcao = 0;
        while(opcao < 7){
            this.imprimir("""
                    (1) Adicionar musica
                    (2) Remover musica
                    (3) Checar se uma musica esta no album
                    (4) Verificar nome da e-nesima musica
                    (5) Imprimir dados do album
                    (6) Alterar posicao de uma musica na lista
                    (7) Sair
                    """);

            opcao = teclado.nextInt();
            teclado.nextLine(); //limpa buffer

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
        boolean ok = album.adicionarMusica(this.lerMusica());
        this.imprimeSucessoOuErro(ok);
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

        if(existe)
            this.imprimir("Essa musica faz parte do album");
        else
            this.imprimir("Essa musica nao faz parte do album");
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

    private Musica lerMusica(){
        this.imprimir("Digite o nome, artista e duracao da musica");

        String nome = teclado.nextLine();
        String artista = teclado.nextLine();
        //teclado.nextLine(); // limpa buffer
        int duracao = teclado.nextInt();

        return new Musica(nome, artista, duracao);
    }

    private List<Musica> lerMusicas(){
        this.imprimir("Digite a quantidade de musicas que deseja inserir");
        int quantidade = teclado.nextInt();

        List<Musica> musicas = new ArrayList<>();

        for(int i = 0; i < quantidade; i++)
            musicas.add(this.lerMusica());

        return musicas;
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
