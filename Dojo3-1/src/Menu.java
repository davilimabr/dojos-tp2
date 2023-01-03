import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Menu {
    private final Scanner teclado = new Scanner(System.in);
    private Turma turma;

    public Menu(){
        this.turma = new Turma();
    }

    public void mostrarMenuPrincipal(){
        int opcao = 0;
        while(opcao != 7){
            this.imprimir("o que deseja fazer?");
            this.imprimir("(1) Listar todos os alunos");
            this.imprimir("(2) Adicionar um novo aluno");
            this.imprimir("(3) Deletar um aluno existente");
            this.imprimir("(4) Ler os atributos de um aluno ");
            this.imprimir("(5) Alterar a idade de um aluno");
            this.imprimir("(6) Adicionar avaliacao a determinado aluno");
            this.imprimir("(7) Sair do programa");

            opcao = this.teclado.nextInt();

            switch (opcao) {
                case 1 -> listarAlunos();
                case 2 -> menuParaAdicionarNovoAluno();
                case 3 -> menuParadeletarAlunoExistente();
                case 4 -> menuParalerAtributosAlunos();
                case 5 -> menuParaAlterarIdadeAluno();
                case 6 -> menuParaAdicionarAvaliacaoAluno();
            }
        }
    }

    private void listarAlunos(){
        for(Aluno aluno : this.turma.getAlunos()){
            imprimir(aluno.toString());
        }
    }

    private void menuParaAdicionarNovoAluno(){
        this.imprimir("Digite a matricula, nome e idade do aluno, respectivamente:");

        int matricula = teclado.nextInt();
        teclado.nextLine();
        String nome = teclado.nextLine();
        int idade = teclado.nextInt();

        Aluno novoAluno = new Aluno(matricula, nome, idade);
        this.imprimeSucessoOuErro(this.turma.adicionarNovoAluno(novoAluno));
    }

    private void menuParadeletarAlunoExistente(){
        this.imprimir("Digite a matricula do aluno");

        int matricula = teclado.nextInt();

        Aluno aluno = this.turma.buscarAlunoPorMatricula(matricula);

        this.imprimeSucessoOuErro(this.turma.deletarAlunoExistente(aluno));
    }

    private void menuParalerAtributosAlunos(){
        this.imprimir("Digite a matricula do aluno");

        int matricula = teclado.nextInt();

        Aluno aluno = this.turma.buscarAlunoPorMatricula(matricula);
        imprimir(aluno.toString());
    }

    private void menuParaAlterarIdadeAluno(){
        imprimir("Digite a matricula do aluno que deseja alterar e a nova idade, respectivamente");

        int matricula = teclado.nextInt();
        int novaIdade = teclado.nextInt();

        Aluno aluno = this.turma.buscarAlunoPorMatricula(matricula);

        this.imprimeSucessoOuErro(this.turma.alterarIdadeAluno(aluno, novaIdade));
    }

    private void menuParaAdicionarAvaliacaoAluno(){
        this.imprimir("Digite o tipo da prova (0 - avaliacao1 | 1 - avaliacao2 | 2 - prova final), a nota, o conteúdo da prova e a matricula do aluno");

        int tipo = teclado.nextInt();
        double nota = teclado.nextDouble();
        String conteudo = teclado.nextLine();
        teclado.nextLine(); //limpar buffer
        int matricula = teclado.nextInt();

        Prova.Tipo tipoProva;
        if(tipo == 0) tipoProva = Prova.Tipo.Avaliacao1;
        else if(tipo == 1) tipoProva = Prova.Tipo.Avaliacao2;
        else tipoProva = Prova.Tipo.ProvaFinal;

        Prova prova = new Prova(tipoProva, nota, conteudo);
        Aluno aluno = this.turma.buscarAlunoPorMatricula(matricula);

        this.imprimeSucessoOuErro(this.turma.adicionarAvaliacaoAluno(prova, aluno));
    }

    public void imprimeSucessoOuErro(boolean operacao){
        if(operacao)
            imprimir("Operação realizada com sucesso");
        else
            imprimir("Não foi possível realizar a operação");
    }
    public void imprimir(String linha){
        System.out.println(linha);
    }
}




