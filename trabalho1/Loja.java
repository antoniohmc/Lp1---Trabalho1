package trabalho1;

import java.util.ArrayList;
import java.util.Collection;

public class Loja {

    private Collection<Pedido> listaPedidos = new ArrayList<>();
    private Collection<Cliente> listaClientes = new ArrayList<>();
    private Collection<Produto> listaProduto = new ArrayList<>();
    private Collection<Vendedor> listaVendedores = new ArrayList<>();


    public Collection<Pedido> listarPedidos() {
        return listaPedidos;
    }

    public void cadastrarPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    public Collection<Cliente> listarClientes() {
        return listaClientes;
    }

    public void cadastrarClientes(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Collection<Produto> listaProduto() {
        return listaProduto;
    }

    public void cadastrarProduto(Produto produto) {
        listaProduto.add(produto);
    }

    public Collection<Vendedor> listaVendedores() {
        return listaVendedores;
    }

    public void cadastrarVendedores(Vendedor vendedor) {
        listaVendedores.add(vendedor);
    }


}
