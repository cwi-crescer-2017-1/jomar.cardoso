/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1jpa.repository;

import br.com.crescer.trabalho1jpa.model.EntidadeBase;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jomar
 * @param <T>
 * @param <ID>
 */
public interface CrudDao<T extends EntidadeBase, Serializable> {
    
    T save(T e);
    void remove(Serializable id);
    T loadById(Serializable id);
    List<T> findAll();
    
}