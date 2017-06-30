/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.services;

import br.com.crescer.redesocial.models.Usuario;
import br.com.crescer.redesocial.repositories.UsuarioRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jomar.cardoso
 */
@Service
public class UsuarioService {
     
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public void post (Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    
    public void delete (BigDecimal id) {
        usuarioRepository.delete(id);
    }
    
    public Usuario loadById (BigDecimal id) {
        return usuarioRepository.findOne(id);
    }
    
    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
