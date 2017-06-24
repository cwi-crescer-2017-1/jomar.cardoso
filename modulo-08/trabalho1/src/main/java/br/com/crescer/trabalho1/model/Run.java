/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jomar
 */
public class Run {
 

 
    public static void main(String[] args) {
 
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER"); 
        final EntityManager em = emf.createEntityManager(); 
        
        //final Cliente cliente = em.find(Cliente.class, 1l); 
        //cliente.setNome("Pedro Henrique Nonnemacher"); 
        
        //até onde sei este é o comando asnotracking
        //em.detach(cliente);
 
        
 
        em.getTransaction().begin(); 
        Cliente cliente = new Cliente("Rocky");
        em.merge(cliente); 
        em.getTransaction().commit(); 

 
        System.out.println(cliente.getNome()); 

 
//        em.persist(cliente);
 
        em.close();
 
        emf.close();
 

 
    }
 
}
 