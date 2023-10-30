package Camadas.Apresentacao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Camadas.Negocios.NegociosCliente;
import Camadas.Negocios.NegociosPedido;
import Entidades.Cliente;
import Entidades.Pedido;

public class ApresentacaoPedido {
    private static NegociosCliente clienteService = new NegociosCliente();
    private static NegociosPedido pedidoService = new NegociosPedido();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("5. Cadastrar Pedido");
            System.out.println("6. Buscar Pedido");
            System.out.println("7. Atualizar Pedido");
            System.out.println("8. Remover Pedido");
            System.out.println("9. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de entrada

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
                    cadastrarPedido();
                    break;
                case 6:
                    buscarPedido();
                    break;
                case 7:
                    atualizarPedido();
                    break;
                case 8:
                    removerPedido();
                    break;
                case 9:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 9);
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
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void cadastrarPedido() {
        System.out.print("Digite o ID do cliente para associar ao pedido: ");
        Long clienteId = scanner.nextLong();
        Cliente cliente = clienteService.buscarCliente(clienteId);
        
        if (cliente != null) {
            System.out.print("Digite a data do pedido (yyyy-MM-dd): ");
            String dataPedidoStr = scanner.next();
            
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dataPedido = dateFormat.parse(dataPedidoStr);
                
                Pedido novoPedido = new Pedido();
                novoPedido.setDataPedido(dataPedido);
                novoPedido.setCliente(cliente);
                
                pedidoService.adicionarPedido(novoPedido);
                System.out.println("Pedido cadastrado com sucesso!");
            } catch (ParseException e) {
                System.out.println("Data de pedido inválida. O pedido não foi cadastrado.");
            }
        } else {
            System.out.println("Cliente não encontrado. O pedido não foi cadastrado.");
        }
    }

    private static void buscarPedido() {
        System.out.print("Digite o ID do pedido: ");
        Long id = scanner.nextLong();
        Pedido pedido = pedidoService.buscarPedido(id);
        
        if (pedido != null) {
            System.out.println("Pedido encontrado:");
            System.out.println("ID: " + pedido.getId());
            System.out.println("Data do Pedido: " + pedido.getDataPedido());
            System.out.println("Cliente: " + pedido.getCliente().getNome());
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    private static void atualizarPedido() {
        System.out.print("Digite o ID do pedido a ser atualizado: ");
        Long id = scanner.nextLong();
        Pedido pedido = pedidoService.buscarPedido(id);
        
        if (pedido != null) {
            System.out.print("Digite a nova data do pedido (yyyy-MM-dd): ");
            String dataPedidoStr = scanner.next();
            
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dataPedido = dateFormat.parse(dataPedidoStr);
                
                pedido.setDataPedido(dataPedido);
                
                pedidoService.atualizarPedido(pedido);
                System.out.println("Pedido atualizado com sucesso!");
            } catch (ParseException e) {
                System.out.println("Data de pedido inválida. O pedido não foi atualizado.");
            }
        } else {
            System.out.println("Pedido não encontrado. A atualização não foi realizada.");
        }
    }

    private static void removerPedido() {
        System.out.print("Digite o ID do pedido a ser removido: ");
        Long id = scanner.nextLong();
        Pedido pedido = pedidoService.buscarPedido(id);
        
        if (pedido != null) {
            pedidoService.removerPedido(id);
            System.out.println("Pedido removido com sucesso!");
        } else {
            System.out.println("Pedido não encontrado. A remoção não foi realizada.");
        }
    }
}
