import java.util.Scanner;

public class Menu {
    private final Scanner teclado = new Scanner(System.in);
    private Biblioteca biblioteca;

    public Menu(){
        this.biblioteca = new Biblioteca();
    }

    public void exibirMenuPrincipal(){
        int opcao = 0;
        while(opcao < 8){
            this.imprimir("(1) Adicionar Cliente");
            this.imprimir("(2) Remover Cliente");
            this.imprimir("(3) Adicionar Livro");
            this.imprimir("(4) Remover Livro");
            this.imprimir("(5) Alugar livro");
            this.imprimir("(6) Devolver livro");
            this.imprimir("(7) Relatório livros emprestados");
            this.imprimir("(8) Sair");

            opcao = teclado.nextInt();
            teclado.nextLine(); // limpar buffer

            switch (opcao){
                case 1 -> menuAdicionarCliente();
                case 2 -> menuRemoverCliente();
                /*case 3 -> menuAdicionarLivro();
                case 4 -> menuRemoverLivro();
                case 5 -> menuEmprestarLivro();       falta implementar o restante das funcionalidades
                case 6 -> menuDevolverLivro();
                case 7 -> menuRelatorioLivros();*/
            }
        }
    }

    public void menuAdicionarCliente(){
        this.imprimir("Digite o nome e cpf do cliente");

        String nome = teclado.next();
        teclado.nextLine(); // limpar buffer

        String cpf = teclado.nextLine();

        Cliente novoCliente = new Cliente(nome, cpf);

        this.imprimeSucessoOuErro(this.biblioteca.adicionar(novoCliente));
    }

    public void menuRemoverCliente(){
        this.imprimir("Digite o cpf do cliente que deseja excluir");

        String cpf = teclado.nextLine();

        Cliente cliente = this.biblioteca.buscaClintePorCpf(cpf);

        this.imprimeSucessoOuErro(this.biblioteca.remover(cliente));
    }

    private void imprimeSucessoOuErro(Boolean operacao){
        if(operacao)
            this.imprimir("Operação realizada com sucesso");
        else
            this.imprimir("Não foi possível realizar a operação");
    }

    private void imprimir(String string){
        System.out.println(string);
    }
}
