/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.persistence;

import Matricula.logic.Periodo;
import Matricula.persistence.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

/**
 *
 * @author atenea
 */
public class PeriodoJpaController implements Serializable {

    public PeriodoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Periodo periodo) throws Exception {
        EntityManager em = null;
        System.out.println("Entro al metodo de crear");
        try {
            System.out.println("comenzo el try");
            List<Periodo> periodos = findPeriodoEntities();
            System.out.println("Leyo la lista de la BD");
            int a =1;
            for (Periodo per : periodos) {
                System.out.println("entro en el for");
                String incia1 = periodo.getInicia(), inicia2=per.getInicia();
                if(incia1.equals("Agosto")){
                    System.out.println("Pregunto respuesta afirmativa");
                    throw new Exception("Periodo ya Creado");
                    
                }else{
                    System.out.println("Pregunto respuesta negativa");
                }
                if (incia1.equals(inicia2)) {
                    JOptionPane.showMessageDialog(null, "Error periodo ya creado");
//                    throw new Exception("Periodo ya Creado");
                }
                System.out.println("Salto o acabo la pregunta");

            }

            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(periodo);
            em.getTransaction().commit();

            //No funciono este arreglo para obtener el error del duplicado
            //###################################
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Periodo periodo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            periodo = em.merge(periodo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = periodo.getId();
                if (findPeriodo(id) == null) {
                    throw new NonexistentEntityException("The periodo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Periodo periodo;
            try {
                periodo = em.getReference(Periodo.class, id);
                periodo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodo with id " + id + " no longer exists.", enfe);
            }
            em.remove(periodo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Periodo> findPeriodoEntities() {
        return findPeriodoEntities(true, -1, -1);
    }

    public List<Periodo> findPeriodoEntities(int maxResults, int firstResult) {
        return findPeriodoEntities(false, maxResults, firstResult);
    }

    private List<Periodo> findPeriodoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Periodo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Periodo findPeriodo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Periodo.class, id);
        } finally {
            em.close();
        }
    }

    public Periodo findPeriodoActual() {
        EntityManager em = getEntityManager();
        return (Periodo) em.createNamedQuery("Periodo.findByActual")
                .setParameter("actual", true)
                .getSingleResult();
    }

    public int getPeriodoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Periodo> rt = cq.from(Periodo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
