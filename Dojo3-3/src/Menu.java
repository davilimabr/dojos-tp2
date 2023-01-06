import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
                case 3 -> menuAdicionarLivro();
                case 4 -> menuRemoverLivro();
                case 5 -> menuEmprestarLivro();
                case 6 -> menuDevolverLivro();
                case 7 -> menuRelatorioAlugueis();
            }
        }
    }

    private void menuAdicionarCliente(){
        this.imprimir("Digite o nome e cpf do cliente");

        String nome = teclado.next();
        teclado.nextLine(); // limpar buffer

        String cpf = teclado.nextLine();

        Cliente novoCliente = new Cliente(nome, cpf);

        this.imprimeSucessoOuErro(this.biblioteca.adicionar(novoCliente));
    }

    private void menuRemoverCliente(){
        this.imprimir("Digite o cpf do cliente que deseja excluir");

        String cpf = teclado.nextLine();

        Cliente cliente = this.biblioteca.buscaClintePorCpf(cpf);

        this.imprimeSucessoOuErro(this.biblioteca.remover(cliente));
    }

    private void menuAdicionarLivro(){
        this.imprimir("Digite o codigo do livro");
        String id = teclado.nextLine();

        this.imprimir("Digite o nome");
        String nome = teclado.nextLine();

        this.imprimir("Digite o autor");
        String autor = teclado.nextLine();

        this.imprimir("Digite o editora");
        String editora = teclado.nextLine();

        this.imprimir("Digite a data de publicação");
        Date dataPublicacao = this.lerData();

        Livro novoLivro = new Livro(id, nome, autor, editora, dataPublicacao);

        this.imprimeSucessoOuErro(this.biblioteca.adicionar(novoLivro));
    }

    private void menuRemoverLivro(){
        this.imprimir("Digite o id do livro");

        String id = teclado.nextLine();
        Livro livro = this.biblioteca.buscaLivroPorId(id);

        this.imprimeSucessoOuErro(this.biblioteca.remover(livro));
    }

    private void menuEmprestarLivro(){
        this.imprimir("Digite o cpf do cliente");
        String cpf = teclado.nextLine();

        this.imprimir("Digite o código do livro");
        String id = teclado.nextLine();

        Cliente cliente = this.biblioteca.buscaClintePorCpf(cpf);
        Livro livro = this.biblioteca.buscaLivroPorId(id);

        try{
            this.biblioteca.alugar(cliente, livro);
            this.imprimeSucessoOuErro(true);
        }catch(Exception ex){
            this.imprimir(ex.getMessage());
        }
    }

    private void menuDevolverLivro(){
        this.imprimir("Digite o código do livro");
        String id = teclado.nextLine();

        Livro livro = this.biblioteca.buscaLivroPorId(id);

        try{
            livro.devolver();
            this.imprimeSucessoOuErro(true);
        }catch(Exception ex){
            this.imprimir(ex.getMessage());
        }
    }

    private void menuRelatorioAlugueis(){
        this.imprimir("Escolha (1)Alugueis por cliente | (2)Alugueis por por livro | (3)Alugueis por período");

        int opcao = teclado.nextInt();


        if(opcao == 1)
            menuRelatorioAlugueisPorCLiente();
        else if(opcao == 2)
            menuRelatorioAlugueisPorLivro();
        else if(opcao == 3)
            menuRelatorioAlugueisPorPeriodo();
    }

    private void menuRelatorioAlugueisPorCLiente(){
        this.imprimir("Digite o cpf do cliente");
        teclado.nextLine(); // limpar buffer
        String cpf = teclado.nextLine();

        Cliente cliente = this.biblioteca.buscaClintePorCpf(cpf);

        this.imprimir(cliente.obterRelatorioAlugueis());
    }

    private void menuRelatorioAlugueisPorLivro(){
        this.imprimir("Digite o id do livro");
        teclado.nextLine(); // limpar buffer
        String id = teclado.nextLine();

        Livro livro = this.biblioteca.buscaLivroPorId(id);

        this.imprimir(livro.obterRelatorioAlugueis());
    }

    private void menuRelatorioAlugueisPorPeriodo(){
        this.imprimir("Digite a data inicio");
        Date dataInicio = this.lerData();

        this.imprimir("Digite a data fim");
        Date dataFim = this.lerData();

        this.imprimir(this.biblioteca.obterRelatorioAlugueis(dataInicio, dataFim));
    }

    private Date lerData(){
        this.imprimir("dia");
        int dia = teclado.nextInt();

        this.imprimir("mes");
        int mes = teclado.nextInt();

        this.imprimir("ano");
        int ano = teclado.nextInt();

        Calendar calendario = new GregorianCalendar();
        calendario.set(ano + 1900, mes, dia);
        return calendario.getTime();
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