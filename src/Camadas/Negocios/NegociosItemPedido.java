package Camadas.Negocios;

import java.util.List;

import Camadas.Dados.DadosItemPedido;
import Entidades.ItemPedido;

public class NegociosItemPedido {
    private DadosItemPedido itemPedidoDAO;

    public NegociosItemPedido() {
        itemPedidoDAO = new DadosItemPedido();
    }

    public void adicionarItemPedido(ItemPedido itemPedido) {
        itemPedidoDAO.adicionarItemPedido(itemPedido);
    }

    public ItemPedido buscarItemPedido(Long id) {
        return itemPedidoDAO.buscarItemPedido(id);
    }

    public void atualizarItemPedido(ItemPedido itemPedido) {
        itemPedidoDAO.atualizarItemPedido(itemPedido);
    }

    public void removerItemPedido(Long id) {
        itemPedidoDAO.removerPedido(id);
    }
    
    public List<ItemPedido> listarItensPedido() {
        return itemPedidoDAO.listarItensPedido();
    }
    
   
}
