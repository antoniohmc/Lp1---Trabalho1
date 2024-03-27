package trabalho1;

import java.time.LocalDate;

public class Vendedor extends Pessoa {
    private String matricula;

    private double percentualComissao;

    private LocalDate dtAdimissao;

    public Vendedor(String nome, String cpf, String matricula, double percentualComissao, LocalDate dtAdimissao) {
        super(nome, cpf);
        this.matricula = matricula;
        this.percentualComissao = percentualComissao;
        this.dtAdimissao = dtAdimissao;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public LocalDate getDtAdimissao() {
        return dtAdimissao;
    }
}
