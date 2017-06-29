/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.repository;

import br.com.crescer.aula7.model.Locacao;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jomar
 */
public interface LocacaoRepository extends CrudRepository<Locacao, Long>{
    
}
