/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.repository;

import br.com.crescer.aula7.model.Funcionario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jomar
 */
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    
}
