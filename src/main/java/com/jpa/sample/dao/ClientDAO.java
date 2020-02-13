package com.jpa.sample.dao;

import com.jpa.sample.domain.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClientDAO implements DAO<Client> {

    private final int MAX_RESULTS = 10;
    private final int FIRST_RESULT = 0;

    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    public void begin() {
        this.emf = Persistence.createEntityManagerFactory("registration-pu");
        this.em = emf.createEntityManager();
    }

    public void close() {
        if (this.em != null) this.em.close();
        if (this.emf != null) this.emf.close();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void save(Client domain) {
        begin();
        em.getTransaction().begin();
        em.persist(domain);
        em.getTransaction().commit();
        close();
    }

    @Override
    public void update(Client domain) {
        begin();
        em.getTransaction().begin();
        em.merge(domain);
        em.getTransaction().commit();
        close();
    }

    @Override
    public void delete(Client domain) {
        begin();

        Client client = em.find(domain.getClass(), domain.getId());

        if (client != null) {
            em.getTransaction().begin();
            em.remove(client);
            em.getTransaction().commit();
        }

        close();
    }

    @Override
    public Client findById(Long domainId) {
        begin();
        Client client = em.find(Client.class, domainId);
        close();
        return client;
    }

    @Override
    public List<Client> findAll() {
        return this.findAll(MAX_RESULTS, FIRST_RESULT);
    }

    @Override
    public List<Client> findAll(int maxResults, int firstResults) {
        begin();

        String jpql = "select c from Client c";
        TypedQuery<Client> query = em.createQuery(jpql, Client.class);
        List<Client> clients = query.setMaxResults(maxResults).setFirstResult(firstResults).getResultList();

        close();

        return clients;
    }
}