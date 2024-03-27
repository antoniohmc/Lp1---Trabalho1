package trabalho1;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private LocalDate dtCadastro;

    public Cliente(String nome, String cpf, LocalDate dtCadastro) {
        super(nome, cpf);
        this.dtCadastro = dtCadastro;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }
}
