/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1.model;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author Jomar
 */
public class GeneroDao extends CrudDaoImpl<Genero, Id>{  
    
    public GeneroDao() {
        super(Genero.class);
    }
        
    public static void main(String[] args) {
        CrudDaoImpl generoDao = new GeneroDao();
        //Entity genero = new Genero("Luta");
        //genero = (Entity) generoDao.save(genero);
        Genero genero = (Genero) generoDao.loadById(1l);
        System.out.println(genero.getDescricao());
    } 



}
