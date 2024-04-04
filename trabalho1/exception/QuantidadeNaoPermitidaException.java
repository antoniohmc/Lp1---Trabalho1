package trabalho1.exception;

import trabalho1.pedido.PedidoItem;
import trabalho1.pedido.Produto;

public class QuantidadeNaoPermitidaException extends Exception {

    public QuantidadeNaoPermitidaException(Produto produto, PedidoItem pedido) {
         if (pedido.getQuantidade() > produto.getQuantidadeMaxima()) {
             System.out.println("A quantidade de itens ja foi exedida");
         }
    }

}
