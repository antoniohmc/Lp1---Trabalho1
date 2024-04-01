package trabalho1;

import java.time.LocalDate;

public class Cliente extends Pessoa implements Comparable<Cliente> {
    private LocalDate dtCadastro;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, LocalDate dtCadastro) {
        super(nome, cpf);
        this.dtCadastro = dtCadastro;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    @Override
    public int compareTo(Cliente cliente) {
        return getNome().compareTo(cliente.getNome());
    }
}
