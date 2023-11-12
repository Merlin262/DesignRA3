package Camadas.Dados;

import java.util.List;

import Entidades.ItemPedido;
import Entidades.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DadosItemPedido {
	
private EntityManagerFactory emf;
    
    public DadosItemPedido() {
        emf = Persistence.createEntityManagerFactory("loja");
    }

    
    public void adicionarItemPedido(ItemPedido itemPedido) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(itemPedido);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
    public static ItemPedido buscarItemPedido(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
        EntityManager em = emf.createEntityManager();
        
        ItemPedido itemPedido = em.find(ItemPedido.class, id);
        
        em.close();
        emf.close();
        
        return itemPedido;
    }

    public void atualizarItemPedido(ItemPedido itemPedido) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(itemPedido);
        em.getTransaction().commit();
        em.close();
    }

    public void removerPedido(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Pedido pedido = em.find(Pedido.class, id);
        if (pedido != null) {
            em.remove(pedido);
        }
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
    public List<ItemPedido> listarItensPedido() {
        EntityManager em = emf.createEntityManager();
        List<ItemPedido> itensPedido = em.createQuery("SELECT ip FROM ItemPedido ip", ItemPedido.class).getResultList();
        em.close();
        return itensPedido;
    }
}
