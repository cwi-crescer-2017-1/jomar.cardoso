/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.service;

import br.com.crescer.redesocial.model.Usuario;
import br.com.crescer.redesocial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Jomar
 */
@Service
public class UsuarioService {
    
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

