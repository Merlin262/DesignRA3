package Camadas.Dados;

import java.util.List;

import Entidades.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DadosProduto {
	
	private EntityManagerFactory emf;

    public DadosProduto(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public void adicionarProduto(Produto produto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }

    public Produto buscarProduto(Long id) {
        EntityManager em = emf.createEntityManager();
        Produto produto = em.find(Produto.class, id);
        em.close();
        return produto;
    }

    public List<Produto> listarProdutos() {
        EntityManager em = emf.createEntityManager();
        List<Produto> produtos = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
        em.close();
        return produtos;
    }

    public void atualizarProduto(Produto produto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
        em.close();
    }

    public void removerProduto(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Produto produto = em.find(Produto.class, id);
        if (produto != null) {
            em.remove(produto);
        }
        em.getTransaction().commit();
        em.close();
    }

}
