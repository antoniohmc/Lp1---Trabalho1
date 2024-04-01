package trabalho1;

import java.util.Collection;
import java.util.Objects;

public class Pedido {

    private Collection<PedidoItem> itens;

    private Cliente cliente;

    private Vendedor vendedor;

    private double total;

    public Pedido(Collection<PedidoItem> itens, Cliente cliente, Vendedor vendedor, double total) {
        this.itens = itens;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = total;
    }

    public Collection<PedidoItem> getItem() {
        return itens;
    }

    public void setItem(Collection<PedidoItem> item) {
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

    public void adicionarItem(PedidoItem item) throws ItemDuplicadoException , QuantidadeNaoPermitidaException{
        itens.add(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pedido pedido = (Pedido) o;
        return itens.equals(pedido.itens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itens);
    }
}
