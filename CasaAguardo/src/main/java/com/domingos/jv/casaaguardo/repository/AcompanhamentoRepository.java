package com.domingos.jv.casaaguardo.repository;

import com.domingos.jv.casaaguardo.database.HibernateUtil;
import com.domingos.jv.casaaguardo.model.Acompanhamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class AcompanhamentoRepository {
    public void salvar(Acompanhamento acompanhamento){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();em.persist(acompanhamento);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public Acompanhamento buscarPorId(Long id){EntityManager em=HibernateUtil.createEntityManager();try{return em.find(Acompanhamento.class,id);}finally{em.close();}}
    public List<Acompanhamento> buscarTodos(){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT a FROM Acompanhamento a",Acompanhamento.class).getResultList();}finally{em.close();}}
    public void atualizar(Acompanhamento acompanhamento){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();em.merge(acompanhamento);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public void remover(Acompanhamento acompanhamento){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();Acompanhamento entidade=em.merge(acompanhamento);em.remove(entidade);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public Acompanhamento buscarPorIdPaciente(Long idPaciente){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT a FROM Acompanhamento a WHERE a.paciente.idPessoa = :idPaciente",Acompanhamento.class).setParameter("idPaciente",idPaciente).getResultStream().findFirst().orElse(null);}finally{em.close();}}
    public List<Acompanhamento> buscarPorIdAcompanhante(Long idAcompanhante){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT a FROM Acompanhamento a WHERE a.acompanhante.idPessoa = :idAcompanhante",Acompanhamento.class).setParameter("idAcompanhante",idAcompanhante).getResultList();}finally{em.close();}}
}
