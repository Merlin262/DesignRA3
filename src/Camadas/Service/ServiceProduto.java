package Camadas.Negocios;

import java.util.List;

import Camadas.Dados.Dados;
import Camadas.Dados.DadosProduto;
import Entidades.Pedido;
import Entidades.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NegociosProduto {
	private EntityManagerFactory emf;
	private DadosProduto produtoDAO;

    public NegociosProduto() {
    	emf = Persistence.createEntityManagerFactory("loja");
        produtoDAO = new DadosProduto(emf);
    }

    public void adicionarProduto(Produto produto) {
        produtoDAO.adicionarProduto(produto);
    }

    public Produto buscarProduto(Long id) {
        return produtoDAO.buscarProduto(id);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listarProdutos();
    }

    public void atualizarProduto(Produto produto) {
        produtoDAO.atualizarProduto(produto);
    }

    public void removerProduto(Long id) {
        produtoDAO.removerProduto(id);
    }
    
}
