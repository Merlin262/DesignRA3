package Camadas.Apresentacao;
import java.util.Scanner;

import Camadas.Negocios.NegociosCliente;
import Camadas.Negocios.NegociosCliente;
import Entidades.Cliente;

public class ApresentacaoCliente {
    private static NegociosCliente clienteService = new NegociosCliente();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("Escolha uma op��o:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("5. Sair");
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
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Op��o inv�lida. Tente novamente.");
            }
        } while (opcao != 5);
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
}
