import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Aluguel{
    private Cliente cliente;
    private Livro livro;
    private Date dataAluguel;
    private Date dataDevolucao;

    public Aluguel(Cliente cliente, Livro livro, Date dataAluguel){
        this.cliente = cliente;
        this.livro = livro;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = null;

        cliente.registrarAluguel(this);
        livro.registrarAluguel(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean estaAtivo(){
        return this.dataDevolucao == null;
    }

    public void encerrar(){
        this.dataDevolucao = Calendar.getInstance().getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluguel aluguel = (Aluguel) o;
        return Objects.equals(cliente, aluguel.cliente) && Objects.equals(livro, aluguel.livro) && Objects.equals(dataAluguel, aluguel.dataAluguel) && Objects.equals(dataDevolucao, aluguel.dataDevolucao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livro);
    }
}
