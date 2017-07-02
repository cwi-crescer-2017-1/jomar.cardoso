/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.services;

import br.com.crescer.redesocial.models.Usuario;
import br.com.crescer.redesocial.repositories.UsuarioRepository;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
    }
    
    public void delete (BigDecimal id) {
        usuarioRepository.delete(id);
    }
    
    public Usuario loadById (BigDecimal id) {
        return usuarioRepository.findOne(id);
    }
    
    public Usuario findByEmail (String username) {
        return usuarioRepository.findByEmail(username);
    }
    
    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    
    public Usuario getLogado() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
        .map(Authentication::getPrincipal)
        .map(User.class::cast)
        .map(User::getUsername)
        .map(this::findByEmail)
        .orElse(null);
    }
}
