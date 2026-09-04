package com.domingos.jv.casaaguardo.repository;

import com.domingos.jv.casaaguardo.database.HibernateUtil;
import com.domingos.jv.casaaguardo.model.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class PacienteRepository {
    public void salvar(Paciente paciente){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();em.persist(paciente);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public Paciente buscarPorId(Long id){EntityManager em=HibernateUtil.createEntityManager();try{return em.find(Paciente.class,id);}finally{em.close();}}
    public List<Paciente> buscarTodos(){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT p FROM Paciente p",Paciente.class).getResultList();}finally{em.close();}}
    public void atualizar(Paciente paciente){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();em.merge(paciente);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public void remover(Paciente paciente){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();Paciente entidade=em.merge(paciente);em.remove(entidade);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public List<Paciente> buscarPorEnfermidade(String enfermidade){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT p FROM Paciente p WHERE p.enfermidade = :enfermidade",Paciente.class).setParameter("enfermidade",enfermidade).getResultList();}finally{em.close();}}
    public List<Paciente> buscarPorVinculo(String vinculo){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT p FROM Paciente p WHERE p.vinculo = :vinculo",Paciente.class).setParameter("vinculo",vinculo).getResultList();}finally{em.close();}}
}
