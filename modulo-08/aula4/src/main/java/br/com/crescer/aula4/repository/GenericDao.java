/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.repository;

import br.com.crescer.aula4.model.EntidadeBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public abstract class GenericDao<T extends EntidadeBase, Serializable> implements CrudDao<T, Serializable> {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER"); 
    private final EntityManager em = emf.createEntityManager();     
    private Class<T> classe;  
    
    public GenericDao(Class<T> classe){
        this.classe = classe;
    }
    
    @Override
    public T save(T t) {        
        try {             
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        }catch(Exception ex) {
            ex.getStackTrace();                       
         } 
        finally {
            em.close(); // no update da erro aqui
            emf.close();            
        } 
        return t;
    }

    @Override
    public void remove(Serializable id) {        
        try {
            em.getTransaction().begin();
            T t = em.find(classe, id);
            em.remove(t); //erro no remove
            em.getTransaction().commit();
        } catch(Exception e) {
            e.getStackTrace(); 
        } finally {
            em.close();
            emf.close();
        }  
    }

    @Override
    public T loadById(Serializable id) {           
        T t = null;
        try {
            t = em.find(classe, id);
        } catch(Exception e) {
            e.getStackTrace(); 
        }
        finally {
            em.close();
        }
        return t;
    }

    @PersistenceContext
    @Override
    public List<T> findAll() {
        List<T> t = null;
        Query query = em.createNamedQuery("EntidadeBase.findAll");
        try {
            t = query.getResultList();
            
        } catch(Exception e) {
            e.getStackTrace(); 
        }
        finally {
            em.close();
        }
        return (List<T>)t;
    }

}
