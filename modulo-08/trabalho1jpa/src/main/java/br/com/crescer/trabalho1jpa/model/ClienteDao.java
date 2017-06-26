/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1jpa.model;

import br.com.crescer.trabalho1jpa.repository.GenericDao;
import javax.persistence.Id;

/**
 *
 * @author Jomar
 */
public class ClienteDao extends GenericDao<Cliente, Id>{  
    
    public ClienteDao() {
        super(Cliente.class);
    }
}
