package trabalho1.pessoa;

import java.time.LocalDate;

public class Vendedor extends Pessoa implements Comparable<Vendedor>{
    private String matricula;

    private double percentualComissao;

    private LocalDate dtAdimissao;

    public Vendedor() {
    }
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

    @Override
    public int compareTo(Vendedor vendedor) {
        return getNome().compareTo(vendedor.getNome());
    }
}
