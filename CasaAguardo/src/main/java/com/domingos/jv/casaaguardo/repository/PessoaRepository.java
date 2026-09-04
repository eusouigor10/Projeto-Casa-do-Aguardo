package com.domingos.jv.casaaguardo.repository;

import com.domingos.jv.casaaguardo.database.HibernateUtil;
import com.domingos.jv.casaaguardo.model.Pessoa;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PessoaRepository {
    public Pessoa buscarPorId(Long id) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try { return entityManager.find(Pessoa.class, id); }
        finally { entityManager.close(); }
    }
    public List<Pessoa> buscarTodos() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try { return entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList(); }
        finally { entityManager.close(); }
    }
    public Pessoa buscarPorCpf(String cpf) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try { return entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.cpf = :cpf", Pessoa.class).setParameter("cpf", cpf).getResultStream().findFirst().orElse(null); }
        finally { entityManager.close(); }
    }
    public List<Pessoa> buscarPorNome(String nome) {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        try { return entityManager.createQuery("SELECT p FROM Pessoa p WHERE LOWER(p.nome) LIKE LOWER(:nome)", Pessoa.class).setParameter("nome", "%" + nome + "%").getResultList(); }
        finally { entityManager.close(); }
    }
}
