package trabalho1.pedido;

import java.util.HashSet;
import trabalho1.pessoa.Cliente;
import trabalho1.exception.ItemDuplicadoException;
import trabalho1.exception.QuantidadeNaoPermitidaException;
import trabalho1.pessoa.Vendedor;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Pedido {

    private Set<PedidoItem> itens;

    private Cliente cliente;

    private Vendedor vendedor;

    private double total;

    public Pedido() {
        this.itens = new HashSet<>();
    }

    public Pedido(Set<PedidoItem> itens, Cliente cliente, Vendedor vendedor, double total) {
        this.itens = itens;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = total;
    }


    public void adicionar(PedidoItem item) throws ItemDuplicadoException{
        if (itens.contains(item)) {
            throw new ItemDuplicadoException();
        }

        itens.add(item);

        double totalPedido = total + total * item.getQuantidade();
    }

    public Collection<PedidoItem> getItens() {
        return itens;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public Vendedor getVendedor() {
        return vendedor;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
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
