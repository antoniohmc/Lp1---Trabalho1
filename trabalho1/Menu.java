package trabalho1;

import java.util.InputMismatchException;
import java.util.Scanner;
import trabalho1.exception.ItemDuplicadoException;
import trabalho1.exception.RegistroNaoEncontradoException;
import trabalho1.pedido.Pedido;
import trabalho1.pedido.Produto;
import trabalho1.pessoa.Cliente;
import trabalho1.pessoa.Vendedor;

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
                        loja.cadastrarProduto(new Produto());
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
                        loja.cadastrarPedido(new Pedido());
                        break;

                    case 5:
                        loja.listarClientes();
                        break;

                    case 6:
                        loja.listaProduto();
                        break;

                    case 7:
                        loja.listaVendedores();
                        break;

                    case 8:
                        loja.listarPedidos();
                        break;

                    case 9:
                        loja.totalBrutoVendas();
                        break;

                    case 0:
                        System.out.println("Saindo do programa. Até mais!");
                        System.exit(0);

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;


                }
            } catch (RegistroNaoEncontradoException | IllegalArgumentException | InputMismatchException |
                     NullPointerException e) {
                e.printStackTrace();
            } catch (ItemDuplicadoException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int imprimirOpcoes(Scanner scanner) {

        System.out.println("\nEscolha uma opção: ");
        System.out.println("1 - Cadastrar produtos");
        System.out.println("2 - Cadastrar clientes");
        System.out.println("3 - Cadastrar vendedores");
        System.out.println("4 - Adicionar pedido");
        System.out.println("5 - Listar clientes");
        System.out.println("6 - Listar produtos");
        System.out.println("7 - Listar vendedores");
        System.out.println("8 - Listar pedidos");
        System.out.println("9 - Total bruto de vendas");
        System.out.println("0 - Sair");

        try {
            return Integer.parseInt(scanner.next());

        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Opção inválida!");
        }
    }

}
