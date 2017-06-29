/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.service;

import br.com.crescer.aula7.model.Funcionario;
import br.com.crescer.aula7.model.Genero;
import br.com.crescer.aula7.model.Video;
import br.com.crescer.aula7.repository.FuncionarioRepository;
import br.com.crescer.aula7.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jomar
 */
@Service
public class FuncionarioService {
    
    @Autowired
    FuncionarioRepository funcionarioRepository;
    
    public void post (Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }
    
    public void delete (Long id) {
        funcionarioRepository.delete(id);
    }
    
    public Funcionario loadById (Long id) {
        return funcionarioRepository.findOne(id);
    }
    
    public Iterable<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }
}
