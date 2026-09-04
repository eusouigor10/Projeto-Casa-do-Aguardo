package com.domingos.jv.casaaguardo.repository;

import com.domingos.jv.casaaguardo.database.HibernateUtil;
import com.domingos.jv.casaaguardo.model.Acompanhante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class AcompanhanteRepository {
    public void salvar(Acompanhante acompanhante) { EntityManager em=HibernateUtil.createEntityManager(); EntityTransaction tx=em.getTransaction(); try { tx.begin(); em.persist(acompanhante); tx.commit(); } catch(Exception e){ if(tx.isActive()) tx.rollback(); throw e; } finally { em.close(); } }
    public Acompanhante buscarPorId(Long id) { EntityManager em=HibernateUtil.createEntityManager(); try{return em.find(Acompanhante.class,id);}finally{em.close();} }
    public List<Acompanhante> buscarTodos() { EntityManager em=HibernateUtil.createEntityManager(); try{return em.createQuery("SELECT a FROM Acompanhante a",Acompanhante.class).getResultList();}finally{em.close();} }
    public void atualizar(Acompanhante acompanhante) { EntityManager em=HibernateUtil.createEntityManager(); EntityTransaction tx=em.getTransaction(); try{tx.begin();em.merge(acompanhante);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();} }
    public void remover(Acompanhante acompanhante) { EntityManager em=HibernateUtil.createEntityManager(); EntityTransaction tx=em.getTransaction(); try{tx.begin();Acompanhante entidade=em.merge(acompanhante);em.remove(entidade);tx.commit();}catch(Exception e){if(tx.isActive())tx.rollback();throw e;}finally{em.close();} }
    public List<Acompanhante> buscarPorDataEntrada(String dataEntrada){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT a FROM Acompanhante a WHERE a.dataEntrada = :dataEntrada",Acompanhante.class).setParameter("dataEntrada",dataEntrada).getResultList();}finally{em.close();}}
    public List<Acompanhante> buscarPorDataSaida(String dataSaida){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT a FROM Acompanhante a WHERE a.dataSaida = :dataSaida",Acompanhante.class).setParameter("dataSaida",dataSaida).getResultList();}finally{em.close();}}
    public List<Acompanhante> buscarPorRenda(Double renda){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT a FROM Acompanhante a WHERE a.renda = :renda",Acompanhante.class).setParameter("renda",renda).getResultList();}finally{em.close();}}
    public List<Acompanhante> buscarPorStatus(String status){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT a FROM Acompanhante a WHERE a.status = :status",Acompanhante.class).setParameter("status",status).getResultList();}finally{em.close();}}
    public List<Acompanhante> buscarPorCidade(String cidade){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT a FROM Acompanhante a WHERE a.cidade = :cidade",Acompanhante.class).setParameter("cidade",cidade).getResultList();}finally{em.close();}}
    public List<Acompanhante> buscarPorUf(String uf){EntityManager em=HibernateUtil.createEntityManager();try{return em.createQuery("SELECT a FROM Acompanhante a WHERE a.uf = :uf",Acompanhante.class).setParameter("uf",uf).getResultList();}finally{em.close();}}
}
