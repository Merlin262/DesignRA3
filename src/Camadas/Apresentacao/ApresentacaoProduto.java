package Camadas.Apresentacao;

import java.util.Scanner;

import Camadas.Negocios.NegociosProduto;
import Entidades.Produto;

import java.util.List;

public class ApresentacaoProduto {
    private static NegociosProduto produtoService = new NegociosProduto();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Buscar Produto");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Atualizar Produto");
            System.out.println("5. Remover Produto");
            System.out.println("6. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de entrada

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    buscarProduto();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    removerProduto();
                    break;
                case 6:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    private static void cadastrarProduto() {
    	System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        Produto novoProduto = new Produto();
        novoProduto.setNome(nome);
        produtoService.adicionarProduto(novoProduto); // Chama o método de ProdutoService
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void buscarProduto() {
        System.out.print("Digite o ID do produto: ");
        Long id = scanner.nextLong();
        Produto produto = produtoService.buscarProduto(id);
        if (produto != null) {
            System.out.println("Produto encontrado:");
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        if (!produtos.isEmpty()) {
            System.out.println("Produtos cadastrados:");
            for (Produto produto : produtos) {
                System.out.println("ID: " + produto.getId());
                System.out.println("Nome: " + produto.getNome());
                System.out.println("------------------------");
            }
        } else {
            System.out.println("Nenhum produto cadastrado.");
        }
    }

    private static void atualizarProduto() {
        System.out.print("Digite o ID do produto a ser atualizado: ");
        Long id = scanner.nextLong();
        Produto produto = produtoService.buscarProduto(id);
        if (produto != null) {
            System.out.print("Digite o novo nome do produto: ");
            String novoNome = scanner.next();
            produto.setNome(novoNome);
            produtoService.atualizarProduto(produto);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void removerProduto() {
        System.out.print("Digite o ID do produto a ser removido: ");
        Long id = scanner.nextLong();
        Produto produto = produtoService.buscarProduto(id);
        if (produto != null) {
            produtoService.removerProduto(id);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
