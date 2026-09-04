package com.domingos.jv.casaaguardo.repository;

import com.domingos.jv.casaaguardo.database.HibernateUtil;
import com.domingos.jv.casaaguardo.model.PacienteInternamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class PacienteInternamentoRepository {
    public void salvar(PacienteInternamento internamento){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();em.persist(internamento);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public PacienteInternamento buscarPorId(Long id){EntityManager em=HibernateUtil.createEntityManager();try{return em.find(PacienteInternamento.class,id);}finally{em.close();}}
    public List<PacienteInternamento> buscarTodos(){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT i FROM PacienteInternamento i",PacienteInternamento.class).getResultList();}finally{em.close();}}
    public void atualizar(PacienteInternamento internamento){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();em.merge(internamento);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public void remover(PacienteInternamento internamento){EntityManager em=HibernateUtil.createEntityManager();EntityTransaction tx=em.getTransaction();try{tx.begin();PacienteInternamento entidade=em.merge(internamento);em.remove(entidade);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();}}
    public List<PacienteInternamento> buscarPorIdPaciente(Long idPaciente){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT i FROM PacienteInternamento i WHERE i.paciente.idPessoa = :idPaciente",PacienteInternamento.class).setParameter("idPaciente",idPaciente).getResultList();}finally{em.close();}}
}
