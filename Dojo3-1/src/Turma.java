import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Turma {
    private List<Aluno> alunos;

    public Turma(){
        this.alunos = new ArrayList<Aluno>();
    }

    public List<Aluno> getAlunos(){
        List<Aluno> alunosClone = new ArrayList<Aluno>(this.alunos);
        return alunosClone;
    }

    public Aluno buscarAlunoPorMatricula(int matricula) {
        for (Aluno aluno : this.alunos)
            if (aluno.getMatricula() == matricula)
                return aluno;

        return null;
    }

    public boolean alterarIdadeAluno(Aluno aluno, int novaIdade){
        int indexAluno = this.alunos.indexOf(aluno);

        if(indexAluno > -1){
            this.alunos.remove(aluno);
            aluno.setIdade(novaIdade);
            this.alunos.add(aluno);
            return true;
        }
        return false;
    }

    public boolean adicionarAvaliacaoAluno(Prova prova, Aluno aluno){
        boolean ok = this.alunos.remove(aluno);
        aluno.adicionarAvaliacao(prova);
        ok = this.alunos.add(aluno);

        return ok;
    }   public boolean adicionarNovoAluno(Aluno novoAluno){
        if(this.alunos.contains(novoAluno))
            return false;

        this.alunos.add(novoAluno);
        return true;
    }

    public boolean deletarAlunoExistente(Aluno aluno){
        return this.alunos.remove(aluno);
    }
}
