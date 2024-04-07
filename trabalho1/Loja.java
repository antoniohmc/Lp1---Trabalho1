package trabalho1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import trabalho1.exception.ItemDuplicadoException;
import trabalho1.exception.RegistroNaoEncontradoException;
import trabalho1.pedido.Pedido;
import trabalho1.pedido.PedidoItem;
import trabalho1.pedido.Produto;
import trabalho1.pessoa.Cliente;
import trabalho1.pessoa.Vendedor;

public class Loja {

    private final Produto produto = new Produto();
    private final PedidoItem pedidoItem = new PedidoItem();
    private final Set<PedidoItem> itens = new HashSet<>();
    private final Collection<Pedido> listaPedidos = new ArrayList<>();
    private final Collection<Cliente> listaClientes = new ArrayList<>();
    private final Collection<Produto> listaProduto = new ArrayList<>();
    private final Collection<Vendedor> listaVendedores = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

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
        System.out.println("Informe o nome do produto: ");
        String nomeProduto = scanner.next();

        System.out.println("Informe o valor do produto: ");
        double valorProduto = scanner.nextDouble();

        System.out.println("Informe a quantidade máxima do produto: ");
        float quantidadeMaximaProduto = scanner.nextFloat();

        System.out.println("Informe o codigo do produto: ");
        int codigoProduto = scanner.nextInt();

        listaProduto.add(new Produto(nomeProduto, valorProduto, quantidadeMaximaProduto, codigoProduto));
    }

    public void cadastrarClientes(Cliente cliente) {
        System.out.println("Informe o nome: ");
        String nomeCliente = scanner.next();

        System.out.println("Informe o cpf: ");
        String cpf = scanner.next();

        System.out.println("Informações de cadastro");
        System.out.println("Informe o ano: ");
        int ano = scanner.nextInt();

        System.out.println("Informe o mês: ");
        int mes = scanner.nextInt();

        System.out.println("Informe o dia");
        int dia = scanner.nextInt();

        LocalDate dtCadastro = LocalDate.of(ano, mes, dia);

        listaClientes.add(new Cliente(nomeCliente, cpf, dtCadastro));
    }

    public void cadastrarVendedores(Vendedor vendedor) {
        System.out.println("Informe o nome: ");
        String nomeVendedor = scanner.next();

        System.out.println("Informe o cpf: ");
        String cpfVendedor = scanner.next();

        System.out.println("Informe a Matricula: ");
        String matricula = scanner.next();

        System.out.println("Percentual de comissâo: ");
        double comissao = scanner.nextDouble();

        System.out.println("Data de Adimissão ");
        System.out.println("Informe o ano: ");
        int anoAdimissao = scanner.nextInt();

        System.out.println("Informe o mês: ");
        int mesAdimissao = scanner.nextInt();

        System.out.println("Informe o dia");
        int diaAdimissao = scanner.nextInt();

        LocalDate dtaAdimissao = LocalDate.of(anoAdimissao, mesAdimissao, diaAdimissao);
        listaVendedores.add(new Vendedor(nomeVendedor, cpfVendedor, matricula, comissao, dtaAdimissao));
    }

    public Collection<Pedido> cadastrarPedido(Pedido pedido)
        throws RegistroNaoEncontradoException, ItemDuplicadoException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Produtos disponíveis:");
        for (Produto produto : listaProduto) {
            System.out.println(
                "Código: " + produto.getCodigo() + " Nome: " + produto.getNome()
                    + " Valor: " + produto.getValor());
        }

        System.out.println("Digite o código do produto que deseja comprar: ");
        int codigoProduto = scanner.nextInt();
        Produto produtoSelecionado = buscarProdutoPorCodigo(codigoProduto);

        if (produtoSelecionado == null) {
            throw new RegistroNaoEncontradoException();
        }

        Cliente clienteSelecionado = buscarClientePorCPF(scanner);

        Vendedor vendedorSelecionado = buscarVendedorPorMatricula(scanner);

        PedidoItem pedidoItem = new PedidoItem(produtoSelecionado, 1);

        pedido.adicionar(pedidoItem);

        pedido.setCliente(clienteSelecionado);
        pedido.setVendedor(vendedorSelecionado);

        double totalPedido = calcularTotalPedido(pedido, produtoSelecionado);

        pedido.setTotal(totalPedido);

        listaPedidos.add(pedido);
        return listaPedidos;
    }

    private Produto buscarProdutoPorCodigo(int codigoProduto) {
        for (Produto produto : listaProduto) {
            if (produto.getCodigo() == codigoProduto) {
                return produto;
            }
        }
        return null;
    }


    public Cliente buscarClientePorCPF(Scanner scanner) throws RegistroNaoEncontradoException {
        System.out.println("Digite o CPF do cliente: ");
        String cpfCliente = scanner.next();

        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpfCliente)) {
                return cliente;
            }
        }

        throw new RegistroNaoEncontradoException();
    }

    public Vendedor buscarVendedorPorMatricula(Scanner scanner) throws RegistroNaoEncontradoException {
        System.out.println("Digite a matrícula do vendedor: ");
        String matriculaVendedor = scanner.next();

        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getMatricula().equals(matriculaVendedor)) {
                return vendedor;
            }
        }

        throw new RegistroNaoEncontradoException();
    }

    public double calcularTotalPedido(Pedido pedido, Produto produto) {
        return pedido.getTotal() + produto.getValor();
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
