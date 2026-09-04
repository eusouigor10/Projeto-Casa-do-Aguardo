package com.domingos.jv.casaaguardo.repository;

import com.domingos.jv.casaaguardo.database.HibernateUtil;
import com.domingos.jv.casaaguardo.model.AcompanhanteTelefone;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class AcompanhanteTelefoneRepository {
    public void salvar(AcompanhanteTelefone telefone){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();em.persist(telefone);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public AcompanhanteTelefone buscarPorId(Long id){EntityManager em=HibernateUtil.createEntityManager();try{return em.find(AcompanhanteTelefone.class,id);}finally{em.close();}}
    public List<AcompanhanteTelefone> buscarTodos(){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT t FROM AcompanhanteTelefone t",AcompanhanteTelefone.class).getResultList();}finally{em.close();}}
    public void atualizar(AcompanhanteTelefone telefone){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();em.merge(telefone);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public void remover(AcompanhanteTelefone telefone){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();AcompanhanteTelefone entidade=em.merge(telefone);em.remove(entidade);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public List<AcompanhanteTelefone> buscarPorIdAcompanhante(Long idAcompanhante){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT t FROM AcompanhanteTelefone t WHERE t.acompanhante.idPessoa = :idAcompanhante",AcompanhanteTelefone.class).setParameter("idAcompanhante",idAcompanhante).getResultList();}finally{em.close();}}
}
