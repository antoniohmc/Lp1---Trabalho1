package trabalho1;

import java.util.ArrayList;
import java.util.Collection;

public class Loja {

    private final Collection<Pedido> listaPedidos = new ArrayList<>();
    private final Collection<Cliente> listaClientes = new ArrayList<>();
    private final Collection<Produto> listaProduto = new ArrayList<>();
    private final Collection<Vendedor> listaVendedores = new ArrayList<>();

    public Loja() {
    }

    public Collection<Pedido> listarPedidos() throws RegistroNaoEncontradoException {
        if (listaPedidos.isEmpty()) {
            throw new RegistroNaoEncontradoException();
        }
        return listaPedidos;
    }

    public void cadastrarPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    public void listarClientes() throws RegistroNaoEncontradoException {
        if (listaClientes.isEmpty()) {
            throw new RegistroNaoEncontradoException();
        }

        listaClientes
            .forEach(cliente -> System.out.println(
                "Nome: " + cliente.getNome() + " CPF: " + cliente.getCpf() + " Cadastro: " + cliente.getDtCadastro()));
    }

    public void cadastrarClientes(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void listaProduto() throws RegistroNaoEncontradoException {
        if (listaProduto.isEmpty()) {
            throw new RegistroNaoEncontradoException();
        }
        listaProduto.forEach(produto -> System.out.println(
            "Nome: " + produto.getNome() + "   Valor: " + produto.getValor() + "   Quantidade Maxima de produtos: "
                + produto.getQuantidadeMaxima() + "   Codigo:" + produto.getCodigo()));
    }

    public void cadastrarProduto(Produto produto) {
        listaProduto.add(produto);
    }

    public Collection<Vendedor> listaVendedores() throws RegistroNaoEncontradoException {
        if (listaVendedores.isEmpty()) {
            throw new RegistroNaoEncontradoException();
        }
        return listaVendedores;
    }

    public void cadastrarVendedores(Vendedor vendedor) {
        listaVendedores.add(vendedor);
    }

    public double totalBrutoVendas() throws RegistroNaoEncontradoException {
        double total = 0;

        for (Pedido p : listarPedidos()) {
            total = p.getTotal();
        }

        return total;
    }

    public double totalLiquidoVendas(Vendedor v) throws RegistroNaoEncontradoException {
        double total = 0;

        for (Pedido p : listarPedidos()) {
            total = p.getTotal() - v.getPercentualComissao();
        }

        return total;
    }


}
