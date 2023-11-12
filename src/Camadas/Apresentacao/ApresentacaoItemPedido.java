package Camadas.Apresentacao;

import java.util.List;
import java.util.Scanner;

import Camadas.Negocios.NegociosItemPedido;
import Camadas.Negocios.NegociosPedido;
import Camadas.Negocios.NegociosProduto;
import Entidades.ItemPedido;
import Entidades.Pedido;
import Entidades.Produto;

public class ApresentacaoItemPedido {
	
	private static NegociosItemPedido itemPedidoService = new NegociosItemPedido();
	private static NegociosPedido pedidoService = new NegociosPedido();
	private static NegociosProduto produtoService = new NegociosProduto();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Item de Pedido");
            System.out.println("2. Buscar Item de Pedido");
            System.out.println("3. Listar Itens de Pedido");
            System.out.println("4. Atualizar Item de Pedido");
            System.out.println("5. Remover Item de Pedido");
            System.out.println("6. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de entrada

            switch (opcao) {
                case 1:
                	adicionarItemPedido();
                    break;
                case 2:
                    buscarItemPedido();
                    break;
                case 3:
                    listarItensPedido();
                    break;
                case 4:
                    atualizarItemPedido();
                    break;
                case 5:
                    removerItemPedido();
                    break;
                case 6:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    private static void adicionarItemPedido() {
    	scanner.nextLine(); // Limpeza do buffer
        System.out.println("ID do Pedido:");
        Long pedidoId = scanner.nextLong();

        Pedido pedido = pedidoService.buscarPedido(pedidoId);

        if (pedido != null) {
            System.out.println("ID do Produto:");
            Long produtoId = scanner.nextLong();
            Produto produto = produtoService.buscarProduto(produtoId);

            if (produto != null) {
                System.out.println("Quantidade:");
                int quantidade = scanner.nextInt();

                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setPedido(pedido);
                itemPedido.setProduto(produto);
                itemPedido.setQuantidade(quantidade);

                itemPedidoService.adicionarItemPedido(itemPedido);
                System.out.println("Item de Pedido adicionado com sucesso.");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    private static void buscarItemPedido() {
    	System.out.println("ID do Item de Pedido:");
        Long id = scanner.nextLong();

        ItemPedido itemPedido = itemPedidoService.buscarItemPedido(id);

        if (itemPedido != null) {
            System.out.println("ID: " + itemPedido.getId());
            System.out.println("Pedido: " + itemPedido.getPedido().getId());
            System.out.println("Produto: " + itemPedido.getProduto().getId());
            System.out.println("Quantidade: " + itemPedido.getQuantidade());
        } else {
            System.out.println("Item de Pedido não encontrado.");
        }
    }

    private static void atualizarItemPedido() {
    	System.out.println("ID do Item de Pedido:");
        Long id = scanner.nextLong();

        ItemPedido itemPedido = itemPedidoService.buscarItemPedido(id);

        if (itemPedido != null) {
            System.out.println("Nova quantidade:");
            int novaQuantidade = scanner.nextInt();

            itemPedido.setQuantidade(novaQuantidade);
            itemPedidoService.atualizarItemPedido(itemPedido);
            System.out.println("Item de Pedido atualizado com sucesso.");
        } else {
            System.out.println("Item de Pedido não encontrado.");
        }
    }

    private static void removerItemPedido() {
    	System.out.println("ID do Item de Pedido:");
        Long id = scanner.nextLong();

        ItemPedido itemPedido = itemPedidoService.buscarItemPedido(id);

        if (itemPedido != null) {
            itemPedidoService.removerItemPedido(id);
            System.out.println("Item de Pedido removido com sucesso.");
        } else {
            System.out.println("Item de Pedido não encontrado.");
        }
    }
    
    private static void listarItensPedido() {
        List<ItemPedido> itensPedido = itemPedidoService.listarItensPedido();
        if (!itensPedido.isEmpty()) {
            System.out.println("Itens de Pedido cadastrados:");
            for (ItemPedido itemPedido : itensPedido) {
                System.out.println("ID: " + itemPedido.getId());
                // Outras informações do Item de Pedido
                System.out.println("------------------------");
            }
        } else {
            System.out.println("Nenhum Item de Pedido cadastrado.");
        }
    }
}

