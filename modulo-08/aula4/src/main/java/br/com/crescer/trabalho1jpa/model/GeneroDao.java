/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1jpa.model;
import br.com.crescer.trabalho1jpa.model.Genero;
import br.com.crescer.trabalho1jpa.repository.GenericDao;
import br.com.crescer.trabalho1jpa.repository.GenericDao;
import javax.persistence.Id;


/**
 *
 * @author Jomar
 */
public class GeneroDao extends GenericDao<Genero, Id>{  
    
    public GeneroDao() {
        super(Genero.class);
    }
}
