package trabalho1;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List <String> itens;

    private Cliente cliente;

    private Vendedor vendedor;

    private double total;

    public Pedido(List<String> itens, Cliente cliente, Vendedor vendedor, double total) {
        this.itens = new ArrayList<>();
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = total;
    }

    public List<String> getItens() {
        return itens;
    }

    public void setItens(List<String> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
