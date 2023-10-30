package Camadas.Dados;
import Entidades.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dados {

	private static EntityManagerFactory emf;

    public Dados() {
        emf = Persistence.createEntityManagerFactory("loja");
    }
    
    public void adicionarCliente(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static Cliente buscarCliente(Long id) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        return cliente;
    }

    public static void atualizarCliente(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void removerCliente(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, id);
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();
    }
    
}
