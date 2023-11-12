package Camadas.Apresentacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Camadas.Negocios.NegociosCliente;
import Camadas.Negocios.NegociosItemPedido;
import Camadas.Negocios.NegociosPedido;
import Camadas.Negocios.NegociosProduto;
import Entidades.Cliente;
import Entidades.ItemPedido;
import Entidades.Pedido;
import Entidades.Produto;

public class Apresentacao {
	private static NegociosCliente clienteService = new NegociosCliente();
	private static NegociosProduto produtoService = new NegociosProduto();
	private static NegociosPedido pedidoService = new NegociosPedido();
	private static NegociosItemPedido itemPedidoService = new NegociosItemPedido();

    private static Scanner scanner = new Scanner(System.in);

    public Apresentacao() {
        
        //scanner = new Scanner(System.in);
    }

    public void executar() {
        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("5. Adicionar Produto");
            System.out.println("6. Buscar Produto");
            System.out.println("7. Atualizar Produto");
            System.out.println("8. Remover Produto");
            System.out.println("9. Adicionar item do pedido");
            System.out.println("10. Buscar Item do Pedido");
            System.out.println("11. atualizar Item do Pedido");
            System.out.println("12. Remover Item do pedido");
            System.out.println("13. Adicionar um pedido");
            System.out.println("14. Buscar um pedido");
            System.out.println("15. Atualizar um pedido");
            System.out.println("16. Remover um pedido");
            System.out.println("17. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                	cadastrarCliente();
                    break;
                case 2:
                    buscarCliente();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    removerCliente();
                    break;
                case 5:
                    adicionarProduto();
                    break;
                case 6:
                    buscarProduto();
                    break;
                case 7:
                    atualizarProduto();
                    break;
                case 8:
                    removerProduto();
                    break;
                case 9:
                	adicionarItemPedido();
                    break;
                case 10:
                	buscarItemPedido();
                    break;
                case 11:
                	atualizarItemPedido();
                    break;
                case 12:
                	removerItemPedido();
                    break;
                case 13:
                	adicionarPedido();
                    break;
                case 14:
                	buscarPedido();
                    break;
                case 15:
                	atualizarPedido();
                    break;
                case 16:
                	removerPedido();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 17);
    }

    private static void cadastrarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(nome);
        clienteService.adicionarCliente(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void buscarCliente() {
        System.out.print("Digite o ID do cliente: ");
        Long id = scanner.nextLong();
        Cliente cliente = clienteService.buscarCliente(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
        } else {
            System.out.println("Cliente n�o encontrado.");
        }
    }

    private static void atualizarCliente() {
        System.out.print("Digite o ID do cliente a ser atualizado: ");
        Long id = scanner.nextLong();
        Cliente cliente = clienteService.buscarCliente(id);
        if (cliente != null) {
            System.out.print("Digite o novo nome do cliente: ");
            String novoNome = scanner.next();
            cliente.setNome(novoNome);
            clienteService.atualizarCliente(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente n�o encontrado.");
        }
    }

    private static void removerCliente() {
        System.out.print("Digite o ID do cliente a ser removido: ");
        Long id = scanner.nextLong();
        Cliente cliente = clienteService.buscarCliente(id);
        if (cliente != null) {
            clienteService.removerCliente(id);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente n�o encontrado.");
        }
    }

    private void adicionarProduto() {
    	scanner.nextLine(); // Limpeza do buffer
        System.out.println("Nome do Produto:");
        String nome = scanner.nextLine();

        Produto produto = new Produto();
        produto.setNome(nome);

        produtoService.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso.");
    }

    private void buscarProduto() {
    	System.out.println("ID do Produto:");
        Long id = scanner.nextLong();

        Produto produto = produtoService.buscarProduto(id);

        if (produto != null) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void atualizarProduto() {
    	System.out.println("ID do Produto:");
        Long id = scanner.nextLong();

        Produto produto = produtoService.buscarProduto(id);

        if (produto != null) {
            scanner.nextLine(); // Limpeza do buffer
            System.out.println("Novo nome do Produto:");
            String novoNome = scanner.nextLine();

            produto.setNome(novoNome);
            produtoService.atualizarProduto(produto);
            System.out.println("Produto atualizado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void removerProduto() {
    	System.out.println("ID do Produto:");
        Long id = scanner.nextLong();

        Produto produto = produtoService.buscarProduto(id);

        if (produto != null) {
            produtoService.removerProduto(id);
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
    
    private void adicionarPedido() {
    	System.out.print("Digite o ID do cliente para associar ao pedido: ");
        Long clienteId = scanner.nextLong();
        Cliente cliente = clienteService.buscarCliente(clienteId);
        
        if (cliente != null) {
            System.out.print("Digite a data do pedido (yyyy-MM-dd): ");
            String dataPedidoStr = scanner.next();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            
            try {
                java.util.Date utilDate = formato.parse(dataPedidoStr); // Converte a string em java.util.Date
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Converte java.util.Date em java.sql.Date
                
                Pedido novoPedido = new Pedido();
                novoPedido.setDataPedido(sqlDate);
                novoPedido.setCliente(cliente);
                
                pedidoService.adicionarPedido(novoPedido);
                System.out.println("Pedido cadastrado com sucesso!");
            } catch (ParseException e) {
                System.out.println("Data de pedido inv�lida. O pedido n�o foi cadastrado.");
            }
        } else {
            System.out.println("Cliente n�o encontrado. O pedido n�o foi cadastrado.");
        }
    }

    private void buscarPedido() {
    	System.out.print("Digite o ID do pedido: ");
        Long id = scanner.nextLong();
        Pedido pedido = pedidoService.buscarPedido(id);
        
        if (pedido != null) {
            System.out.println("Pedido encontrado:");
            System.out.println("ID: " + pedido.getId());
            System.out.println("Data do Pedido: " + pedido.getDataPedido());
            System.out.println("Cliente: " + pedido.getCliente().getNome());
        } else {
            System.out.println("Pedido n�o encontrado.");
        }
    }

    private void atualizarPedido() {
    	System.out.print("Digite o ID do pedido a ser atualizado: ");
        Long id = scanner.nextLong();
        Pedido pedido = pedidoService.buscarPedido(id);
        
        if (pedido != null) {
            System.out.print("Digite a nova data do pedido (yyyy-MM-dd): ");
            String dataPedidoStr = scanner.next();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            
            try {
            	java.util.Date utilDate = formato.parse(dataPedidoStr); // Converte a string em java.util.Date
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // Converte java.util.Date em java.sql.Date
            
                
                pedido.setDataPedido(sqlDate);
                
                pedidoService.atualizarPedido(pedido);
                System.out.println("Pedido atualizado com sucesso!");
            } catch (ParseException e) {
                System.out.println("Data de pedido inv�lida. O pedido n�o foi atualizado.");
            }
        } else {
            System.out.println("Pedido n�o encontrado. A atualiza��o n�o foi realizada.");
        }
    }

    private void removerPedido() {
    	System.out.print("Digite o ID do pedido a ser removido: ");
        Long id = scanner.nextLong();
        Pedido pedido = pedidoService.buscarPedido(id);
        
        if (pedido != null) {
            pedidoService.removerPedido(id);
            System.out.println("Pedido removido com sucesso!");
        } else {
            System.out.println("Pedido n�o encontrado. A remo��o n�o foi realizada.");
        }
    }

    private void adicionarItemPedido() {
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

    private void buscarItemPedido() {
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

    private void atualizarItemPedido() {
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

    private void removerItemPedido() {
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

    public static void main(String[] args) {
        Apresentacao apresentacao = new Apresentacao();
        apresentacao.executar();
    }
}
