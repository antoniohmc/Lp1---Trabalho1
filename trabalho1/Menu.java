package trabalho1;

import trabalho1.pedido.Produto;
import trabalho1.exception.RegistroNaoEncontradoException;
import trabalho1.pessoa.Cliente;
import trabalho1.pessoa.Vendedor;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Loja loja = new Loja() {

        };

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int escolha = imprimirOpcoes(scanner);

                switch (escolha) {
                    case 1:
                        System.out.println("Informe o nome do produto: ");
                        String nomeProduto = scanner.next();

                        System.out.println("Informe o valor do produto: ");
                        double valorProduto = scanner.nextDouble();

                        System.out.println("Informe a quantidade máxima do produto: ");
                        float quantidadeMaximaProduto = scanner.nextFloat();

                        System.out.println("Informe o codigo do produto: ");
                        int codigoProduto = scanner.nextInt();

                        loja.cadastrarProduto(new Produto(nomeProduto,valorProduto,quantidadeMaximaProduto,codigoProduto));
                        System.out.println("Produto cadastrado com sucesso!!");
                        break;

                    case 2:
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

                        LocalDate dtCadastro = LocalDate.of(ano , mes , dia);

                        loja.cadastrarClientes(new Cliente(nomeCliente, cpf, dtCadastro));
                        System.out.println("Cliente cadastrado com sucesso!!");
                        break;

                    case 3:
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

                        loja.cadastrarVendedores(new Vendedor(nomeVendedor, cpfVendedor, matricula, comissao, dtaAdimissao));
                        System.out.println("Vendedor cadastrado com sucesso!!");
                        break;

                    case 4:
                        loja.listarClientes();
                        break;

                    case 5:
                        loja.listaProduto();
                        break;

                    case 6:
                        loja.listaVendedores();
                        break;

                    case 7:
                        loja.listarPedidos();
                        break;

                    case 8:
                        loja.totalBrutoVendas();
                        break;

                    case 9:
                        loja.totalLiquidoVendas(new Vendedor());
                        break;

                    case 0:
                        System.out.println("Saindo do programa. Até mais!");
                        System.exit(0);

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;


                }
            } catch (RegistroNaoEncontradoException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException | InputMismatchException e) {
                e.printStackTrace();
            }
        }
    }

    public static int imprimirOpcoes(Scanner scanner) {

        System.out.println("\nEscolha uma opção: ");
        System.out.println("1 - Cadastrar produtos");
        System.out.println("2 - Cadastrar clientes");
        System.out.println("3 - Cadastrar vendedores");
        System.out.println("4 - Listar clientes");
        System.out.println("5 - Listar produtos");
        System.out.println("6 - Listar vendedores");
        System.out.println("7 - Listar pedidos");
        System.out.println("8 - Total bruto de vendas");
        System.out.println("9 - total liquido de vendas");
        System.out.println("0 - Sair");

        try {
            return Integer.parseInt(scanner.next());

        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Opção inválida!");
        }
    }

}
