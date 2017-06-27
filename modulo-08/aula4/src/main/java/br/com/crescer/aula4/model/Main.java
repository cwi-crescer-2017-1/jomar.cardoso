/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.model;

import br.com.crescer.aula4.repository.GenericDao;

/**
 *
 * @author Jomar
 */
public class Main {
        public static void main(String[] args) {
        GenericDao generoDao = new GeneroDao();
        EntidadeBase genero = new Genero("Russo");
        genero = (EntidadeBase) generoDao.save(genero);
        //Genero genero = (Genero) generoDao.loadById(1l);
        //System.out.println(genero.getDescricao());
        //generoDao.findAll();
        //generoDao.remove(17l);
        
        //GenericDao clienteDao = new ClienteDao();
        //EntidadeBase cliente = new Cliente("Comédia");
        //cliente = (EntidadeBase) clienteDao.save(cliente);
        
    } 
}
