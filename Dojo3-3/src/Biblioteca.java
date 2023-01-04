import java.util.*;

public class Biblioteca {
    private List<Cliente> clientes;
    private List<Livro> livros;
    private List<Aluguel> alugueisAtivos;
    private List<Aluguel> historicoAlugueis;


    public Biblioteca(){
        this.clientes = new ArrayList<Cliente>();
        this.livros = new ArrayList<Livro>();
        this.alugueisAtivos = new ArrayList<Aluguel>();
        this.historicoAlugueis = new ArrayList<Aluguel>();
    }

    public boolean adicionar(Cliente novoCliente){
        return this.clientes.add(novoCliente);
    }

    public boolean remover(Cliente cliente){
        return this.clientes.remove(cliente);
    }

    public boolean adicionar(Livro novoLivro){
        return this.livros.add(novoLivro);
    }

    public boolean remover(Livro livro){
        return this.livros.remove(livro);
    }

    public boolean ALugar(Cliente cliente, Livro livro){
        if(contaAlugueisAtivosPorCliente(cliente) >= 2) return false;

        List<Aluguel> historicoCliente = obterHistoricoAlugueisPorCliente(cliente);
        for(int i = 0; i < 3; i ++)
            if(historicoCliente.get(i).getLivro().equals(livro)) return false;

        if(livroAlugado(livro)) return false;

        Aluguel novoAluguel = new Aluguel(cliente, livro, Calendar.getInstance());

        boolean ok = this.alugueisAtivos.add(novoAluguel);
        this.ordenaAlugueis();
        return ok;
    }

    public boolean Devolver(Cliente cliente, Livro livro){
        Aluguel aluguel = this.buscaAluguelAtivo(cliente, livro);

        boolean ok = this.alugueisAtivos.remove(aluguel);

        if(ok){
            this.historicoAlugueis.add(aluguel);
            ordenaAlugueis();
            return true;
        }
        else return false;
    }

    public String obterRelatorioAlugueis(Calendar minimo, Calendar maximo, Livro livro){
        String relatorio = String.format("Relatorio de alugueis do livro %s", livro.getNome());

        for(Aluguel aluguel : this.historicoAlugueis)
            if(aluguel.getLivro().equals(livro)){
                Cliente cliente = aluguel.getCliente();
                relatorio += String.format("Data do Aluguel: %s | Nome Cliente: %s | CPF: %s", aluguel.getDataAluguel().toString(),
                        cliente.getNome(), cliente.getCpf());
            }

        return relatorio;
    }

    public List<Aluguel> obterHistoricoAlugueisPorCliente(Cliente cliente){
        List<Aluguel> alugueisCliente = new ArrayList<Aluguel>();

        for(Aluguel aluguel : this.historicoAlugueis)
            if(aluguel.getCliente().equals(cliente))
                alugueisCliente.add(aluguel);

        return alugueisCliente;
    }

    public boolean livroAlugado(Livro livro){
        for(Aluguel aluguel : this.alugueisAtivos)
            if(aluguel.getLivro().equals(livro)) return true;

        return false;
    }

    public Cliente buscaClintePorCpf(String cpf){
        for(Cliente cliente : this.clientes)
            if(cliente.getCpf().equals(cpf))
                return cliente;

        return null;
    }

    private Aluguel buscaAluguelAtivo(Cliente cliente, Livro livro){
        for(Aluguel aluguel : this.alugueisAtivos)
            if(aluguel.getCliente().equals(cliente) && aluguel.getLivro().equals(livro))
                return aluguel;

        return null;
    }

    private void ordenaAlugueis(){
        Collections.sort(this.alugueisAtivos);
        Collections.sort(this.historicoAlugueis);
    }

    private int contaAlugueisAtivosPorCliente(Cliente cliente){
        int contador = 0;
        for(Aluguel aluguel : this.alugueisAtivos)
            if(aluguel.getCliente().equals(cliente))
                contador++;

        return contador;
    }
}
