package trabalho1.pedido;


public class Produto {

    private String nome;

    private double valor;

    private float quantidadeMaxima;

    private int codigo;

    public Produto() {
    }

    public Produto(String nome, double valor, float quantidadeMaxima, int codigo) {
        this.nome = nome;
        this.valor = valor;
        this.quantidadeMaxima = quantidadeMaxima;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public float getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(float quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
