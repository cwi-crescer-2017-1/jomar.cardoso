/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;

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
    
    public Iterable<Genero> todos() {
        return generoRepository.findAll();
    }
}
