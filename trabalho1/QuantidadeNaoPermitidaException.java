package trabalho1;

public class QuantidadeNaoPermitidaException extends Exception {

    public QuantidadeNaoPermitidaException(Produto produto, PedidoItem pedido) {
         if (pedido.getQuantidade() > produto.getQuantidadeMaxima()) {
             System.out.println("A quantidade de itens ja foi exedida");
         }
    }

}
