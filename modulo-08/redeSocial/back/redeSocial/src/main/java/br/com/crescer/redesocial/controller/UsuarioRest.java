/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.controller;

import br.com.crescer.redesocial.model.Usuario;
import br.com.crescer.redesocial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jomar
 */
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRest {
     @Autowired
    UsuarioRepository usuarioRepository;
    
    public void post (Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    
    public void delete (Long id) {
        usuarioRepository.delete(id);
    }
    
    public Usuario loadById (Long id) {
        return usuarioRepository.findOne(id);
    }
    
    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
