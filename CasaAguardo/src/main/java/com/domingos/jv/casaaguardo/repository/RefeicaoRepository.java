package com.domingos.jv.casaaguardo.repository;

import com.domingos.jv.casaaguardo.database.HibernateUtil;
import com.domingos.jv.casaaguardo.model.Refeicao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class RefeicaoRepository {
    public void salvar(Refeicao refeicao){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();em.persist(refeicao);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public Refeicao buscarPorId(Long id){EntityManager em=HibernateUtil.createEntityManager();try{return em.find(Refeicao.class,id);}finally{em.close();}}
    public List<Refeicao> buscarTodos(){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT r FROM Refeicao r",Refeicao.class).getResultList();}finally{em.close();}}
    public void atualizar(Refeicao refeicao){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();em.merge(refeicao);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public void remover(Refeicao refeicao){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();Refeicao entidade=em.merge(refeicao);em.remove(entidade);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public List<Refeicao> buscarPorTipo(String tipo){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT r FROM Refeicao r WHERE r.tipo = :tipo",Refeicao.class).setParameter("tipo",tipo).getResultList();}finally{em.close();}}
    public List<Refeicao> buscarPorData(String data){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT r FROM Refeicao r WHERE r.data = :data",Refeicao.class).setParameter("data",data).getResultList();}finally{em.close();}}
}
