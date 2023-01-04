public class Cliente{
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(Cliente cliente){
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Cliente)) return false;

        return ((Cliente) o).getCpf().equals(this.cpf);
    }
}
