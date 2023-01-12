import java.util.*;

public class Biblioteca {
    private List<Cliente> clientes;
    private List<Livro> livros;
    private List<Aluguel> alugueis;

    public Biblioteca(){
        this.clientes = new ArrayList<Cliente>();
        this.livros = new ArrayList<Livro>();
        this.alugueis = new ArrayList<Aluguel>();
    }

    public boolean adicionar(Cliente novoCliente){
        if(!this.clientes.contains(novoCliente)){
            this.clientes.add(novoCliente);
            return true;
        }
        return false;
    }

    public boolean remover(Cliente cliente){
        return this.clientes.remove(cliente);
    }

    public boolean adicionar(Livro novoLivro){
        if(!this.livros.contains(novoLivro)){
            this.livros.add(novoLivro);
            return true;
        }
        return false;
    }

    public boolean remover(Livro livro){
        return this.livros.remove(livro);
    }

    public void alugar(Cliente cliente, Livro livro) throws Exception{
        if(cliente.possuiMaisQueDoisAlugueisAtivos())
            throw new Exception("O cliente já possui dois livros emprestados.");
        if(cliente.livroAlugadoUltimosTresAlugueis(livro))
            throw new Exception("Cliente já alugou esse livro nos últimos três emprestimos");
        if(livro.estaALugado())
            throw new Exception("Livro já está emprestado");

        Date dataAluguel = Calendar.getInstance().getTime();
        this.alugueis.add(new Aluguel(cliente, livro, dataAluguel));
    }

    public void devolver(Livro livro){
         livro.devolver();
    }

    public String obterRelatorioAlugueis(Date minimo, Date maximo){
        String relatorio = "";
        for(Aluguel aluguel : this.alugueis)
            if(aluguel.getDataAluguel().compareTo(minimo) > 0 && aluguel.getDataAluguel().compareTo(maximo) < 0)
                relatorio += String.format("Cliente:\n%s\nLivro:\n%s\nData Aluguel: %s\nData Devolução: %s\n",
                        aluguel.getCliente().toString(), aluguel.getLivro().toString(), aluguel.getDataAluguel().toString(),
                        aluguel.getDataDevolucao().toString());

        return relatorio;
    }

    public Cliente buscaClintePorCpf(String cpf){
        for(Cliente cliente : this.clientes)
            if(cliente.getCpf().equals(cpf))
                return cliente;

        return null;
    }

    public Livro buscaLivroPorId(String id){
        for(Livro livro : this.livros)
            if(livro.getId().equals(id))
                return livro;

        return null;
    }

}
