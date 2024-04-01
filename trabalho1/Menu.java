package trabalho1;

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
                        String nome = scanner.next();

                        System.out.println("Informe o valor do produto: ");
                        double valor = scanner.nextDouble();

                        System.out.println("Informe a quantidade máxima do produto: ");
                        float quantidadeMaxima = scanner.nextFloat();

                        System.out.println("Informe o codigo do produto: ");
                        int codigo = scanner.nextInt();

                        loja.cadastrarProduto(new Produto(nome,valor,quantidadeMaxima,codigo));
                        System.out.println("Produto cadastrado com sucesso!!");
                        break;

                    case 2:
                        loja.cadastrarClientes(new Cliente());
                        System.out.println("Cliente cadastrado com sucesso!!");
                        break;

                    case 3:
                        loja.cadastrarVendedores(new Vendedor());
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
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
        }
    }

    private static int imprimirOpcoes(Scanner scanner) {

        System.out.println("\nEscolha uma opção");
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
