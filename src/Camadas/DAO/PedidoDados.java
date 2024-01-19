package Camadas.Dados;

import Entidades.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PedidoDados {
    private EntityManagerFactory emf;

    public PedidoDados(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void adicionarPedido(Pedido pedido) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();
        em.close();
    }

    public Pedido buscarPedido(Long id) {
        EntityManager em = emf.createEntityManager();
        Pedido pedido = em.find(Pedido.class, id);
        em.close();
        return pedido;
    }

    public void atualizarPedido(Pedido pedido) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pedido);
        em.getTransaction().commit();
        em.close();
    }

    public void removerPedido(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Pedido pedido = em.find(Pedido.class, id);
        em.remove(pedido);
        em.getTransaction().commit();
        em.close();
    }
}