package trabalho1;

import trabalho1.exception.RegistroNaoEncontradoException;
import trabalho1.pedido.Pedido;
import trabalho1.pedido.PedidoItem;
import trabalho1.pedido.Produto;
import trabalho1.pessoa.Cliente;
import trabalho1.pessoa.Vendedor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Loja {

    Scanner scanner = new Scanner(System.in);

    private final Produto produto = new Produto();

    private final PedidoItem pedidoItem = new PedidoItem();

    private final Collection<Pedido> listaPedidos = new ArrayList<>();
    private final Collection<Cliente> listaClientes = new ArrayList<>();
    private final Collection<Produto> listaProduto = new ArrayList<>();
    private final Collection<Vendedor> listaVendedores = new ArrayList<>();

    public Loja() {
    }

    public Collection<Pedido> listarPedidos() {
        if (listaPedidos.isEmpty()) {
            System.out.println("Lista vazia");
        }

        listaPedidos.forEach(pedido -> System.out.println("Cliente " + pedido.getCliente()
                + " Vendedor " + pedido.getVendedor()
                + " Itens " + pedido.getItens()
                + " total " + pedido.getTotal()));
        return listaPedidos;
    }

    public void listarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Lista vazia");
        }

        listaClientes
                .forEach(cliente -> System.out.println(
                        "Nome: " + cliente.getNome()
                                + " CPF: " + cliente.getCpf()
                                + " Cadastro: " + cliente.getDtCadastro()));
    }

    public void listaProduto() {
        if (listaProduto.isEmpty()) {
            System.out.println("Lista vazia");
        }
        listaProduto.forEach(produto -> System.out.println(
                "Nome: " + produto.getNome() + " Valor: " + produto.getValor()
                        + " Quantidade Maxima de produtos: " + produto.getQuantidadeMaxima()
                        + " Codigo:" + produto.getCodigo()));
    }

    public void listaVendedores() {
        if (listaVendedores.isEmpty()) {
            System.out.println("Lista vazia");
        }
        listaVendedores.forEach(vendedor -> System.out.println("Nome: " + vendedor.getNome()
                + " Cpf: " + vendedor.getCpf()
                + " Matricula: " + vendedor.getMatricula()
                + " Percentual de comissão: " + vendedor.getPercentualComissao()
                + " Data de adimissão: " + vendedor.getDtAdimissao()));
    }

    public void cadastrarProduto(Produto produto) {
        listaProduto.add(produto);
    }

    public void cadastrarClientes(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void cadastrarVendedores(Vendedor vendedor) {
        listaVendedores.add(vendedor);
    }

    public void cadastrarPedido(Pedido pedido) throws RegistroNaoEncontradoException {
        listaProduto.forEach(produto -> System.out.println(
                "Nome: " + produto.getNome() + " Valor: " + produto.getValor()
                        + " Quantidade Maxima de produtos: " + produto.getQuantidadeMaxima()
                        + " Codigo:" + produto.getCodigo()));

        int codigo = produto.getCodigo();

        System.out.println("Digite o codigo do produto que deseja comprar: ");
        codigo = scanner.nextInt();

        if (listaProduto.contains(codigo)) {

        listaPedidos.add(pedido);
        } else
            throw new RegistroNaoEncontradoException();
    }

    public double totalBrutoVendas() {
        double total = 0;

        for (Pedido p : listarPedidos()) {
            total += produto.getValor() * pedidoItem.getQuantidade();
        }

        return total;
    }

    public double totalLiquidoVendas(Vendedor vendedor) {
        double total = 0;

        for (Pedido p : listarPedidos()) {
            total += produto.getValor() * pedidoItem.getQuantidade() - vendedor.getPercentualComissao();
        }

        return total;
    }
}
