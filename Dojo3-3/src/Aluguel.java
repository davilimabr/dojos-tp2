import java.util.Calendar;

public class Aluguel implements Comparable<Aluguel> {
    private Cliente cliente;
    private Livro livro;
    private Calendar dataAluguel;

    public Aluguel(Cliente cliente, Livro livro, Calendar dataAluguel){
        this.cliente = cliente;
        this.livro = livro;
        this.dataAluguel = dataAluguel;
    }

    public Cliente getCliente() {
        return new Cliente(this.cliente);
    }

    public Livro getLivro() {
        return new Livro(this.livro);
    }

    public Calendar getDataAluguel() {
        return (Calendar) dataAluguel.clone();
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Aluguel)) return false;

        Aluguel aluguel = ((Aluguel) o);
        return aluguel.getCliente().equals(this.cliente) && aluguel.getLivro().equals(this.livro);
    }

    @Override
    public int compareTo(Aluguel aluguel){
        return this.dataAluguel.compareTo(aluguel.getDataAluguel());
    }
}
