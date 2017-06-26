/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public abstract class CrudDaoImpl<Entity, ID> implements CrudDao<Entity, ID> {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER"); 
    private final EntityManager em = emf.createEntityManager();     
    private final Session session = (Session) em.unwrap(Session.class);
    private Class<Entity> classe;  
    private Transaction transaction;
    
    public CrudDaoImpl(Class<Entity> classe){
        this.classe = classe;
    }
    
    @Override
    public Entity save(Entity e) {        
        try {
            transaction = session.beginTransaction();
            session.save(e);
        } catch(HibernateException ex) {
            ex.getStackTrace();                       
        } finally {
            session.flush();  
            session.close();
            emf.close();
            emf.close();            
        } 
        return e;
    }

    @Override
    public void remove(Entity e) {
        try {
            transaction = session.beginTransaction();
            session.delete(e);
        } catch(HibernateException ex) {
            ex.getStackTrace(); 
        } finally {
            session.flush();
            session.close();
            em.close();
            emf.close();
        }  
    }

    @Override
    public Entity loadById(ID id) {           
        Entity retorno = (Entity) session.load(classe, (Serializable) id); 
        em.close();
        emf.close();
        return retorno;
    }

    @Override
    public List<Entity> findAll() {
        List<Entity> lista = session.createCriteria(classe.getClass()).list(); 
        em.close();
        emf.close();
        return lista;
    }
}
