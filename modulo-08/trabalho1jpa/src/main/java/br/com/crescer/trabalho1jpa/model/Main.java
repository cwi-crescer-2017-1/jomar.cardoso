/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1jpa.model;

import br.com.crescer.trabalho1jpa.repository.GenericDao;

/**
 *
 * @author Jomar
 */
public class Main {
        public static void main(String[] args) {
        //GenericDao generoDao = new GeneroDao();
        //EntidadeBase genero = new Genero(1l, "Comédia");
        //genero = (EntidadeBase) generoDao.save(genero);
        //Genero genero = (Genero) generoDao.loadById(1l);
        //System.out.println(genero.getDescricao());
        //generoDao.findAll();
        //generoDao.remove(17l);
        
        GenericDao clienteDao = new ClienteDao();
    } 
}
