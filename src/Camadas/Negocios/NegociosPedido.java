package Camadas.Negocios;

import Camadas.Dados.PedidoDados;
import Entidades.Pedido;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NegociosPedido {
    private EntityManagerFactory emf;
    private PedidoDados pedidoDAO;

    public NegociosPedido() {
        emf = Persistence.createEntityManagerFactory("loja");
        pedidoDAO = new PedidoDados(emf);
    }

    public void adicionarPedido(Pedido pedido) {
        pedidoDAO.adicionarPedido(pedido);
    }

    public Pedido buscarPedido(Long id) {
        return pedidoDAO.buscarPedido(id);
    }

    public void atualizarPedido(Pedido pedido) {
        pedidoDAO.atualizarPedido(pedido);
    }

    public void removerPedido(Long id) {
        pedidoDAO.removerPedido(id);
    }
}
