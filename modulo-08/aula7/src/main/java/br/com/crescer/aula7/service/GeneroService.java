/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.service;

import br.com.crescer.aula7.repository.GeneroRepository;
import br.com.crescer.aula7.model.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jomar.cardoso
 */
@Service
public class GeneroService {
    
    @Autowired
    GeneroRepository generoRepository;
    
    public void post (Genero genero) {
        generoRepository.save(genero);
    }
    
    public void delete (Long id) {
        generoRepository.delete(id);
    }
    
    public Genero loadById (Long id) {
        return generoRepository.findOne(id);
    }
    
    public Iterable<Genero> findAll() {
        return generoRepository.findAll();
    }
}
