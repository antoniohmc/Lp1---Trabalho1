package trabalho1.pessoa;

import java.time.LocalDate;

public class Cliente extends Pessoa {
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

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }


}
