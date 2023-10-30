package Camadas.Negocios;

import Camadas.Dados.Dados;
import Entidades.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NegociosCliente {
    private EntityManagerFactory emf;
    private Dados clienteDAO;

    public NegociosCliente() {
        emf = Persistence.createEntityManagerFactory("loja");
        clienteDAO = new Dados();
    }

    public void adicionarCliente(Cliente cliente) {
        clienteDAO.adicionarCliente(cliente);
    }

    public Cliente buscarCliente(Long id) {
        return clienteDAO.buscarCliente(id);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizarCliente(cliente);
    }

    public void removerCliente(Long id) {
        clienteDAO.removerCliente(id);
    }

}
