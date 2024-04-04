package trabalho1.pedido;

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

    public Pedido(Cliente cliente, Vendedor vendedor) {
        this.itens = new LinkedHashSet<>();
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = 0;
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
