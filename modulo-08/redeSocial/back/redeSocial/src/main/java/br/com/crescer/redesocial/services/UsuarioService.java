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
import java.util.Set;
import static java.util.stream.Collectors.toSet;
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

    public void post(Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        usuarioRepository.save(usuario);

    }

    public void put(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void delete(BigDecimal id) {
        usuarioRepository.delete(id);
    }

    public Usuario loadById(BigDecimal id) {
        return usuarioRepository.findOne(id);
    }

    public Usuario findByEmail(String username) {
        return usuarioRepository.findByEmail(username);
    }

    public Set<Usuario> getAmigos() {
        return usuarioRepository.findByEmail(this.getLogado().getEmail()).getAmigo();
    }

    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario getLogado() {
        try {
            return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                    .map(Authentication::getPrincipal)
                    .map(User.class::cast)
                    .map(User::getUsername)
                    .map(this::findByEmail)
                    .orElse(null);
        } catch (Exception e) {
            return null;
        }
    }



    public Set<Usuario> getInimigos() {
        final Usuario logado = this.getLogado();
        final Set<BigDecimal> ids = logado.getAmigo().stream()
                .map(Usuario::getId)
                .collect(toSet());
        final Set<Usuario> amigos = logado.getAmigo();
        ids.add(logado.getId());
        return usuarioRepository.findByIdNotIn(ids);        
    }

    public void enviarConviteAmizade(BigDecimal id) {
        Usuario solicitante = this.getLogado();
        Usuario solicitado = this.loadById(id);
        solicitado.getSolicitacaoamizade().add(solicitante);
        this.put(solicitado);
    }

    public void cancelarConviteAmizade(BigDecimal id) {
        Usuario solicitante = this.getLogado();
        Usuario solicitado = this.loadById(id);
        solicitado.getSolicitacaoamizade()
                .stream()
                .filter(p -> p.getId() != solicitante.getId())
                .collect(toSet());
        this.put(solicitado);
    }

    public void aceitarAmizade(BigDecimal id) {
        Usuario solicitante = this.loadById(id);
        Usuario solicitado = this.getLogado();
        solicitante.getSolicitacaoamizade().remove(solicitado);
        solicitante.getAmigo().add(solicitado);
        solicitado.getSolicitacaoamizade().remove(solicitante);
        solicitado.getAmigo().add(solicitante);
        this.put(solicitado);
        this.put(solicitante);
    }

    public void rejeitarAmizade(BigDecimal id) {
        Usuario solicitado = this.getLogado();
        Usuario solicitante = this.loadById(id);
        solicitado.getSolicitacaoamizade()
                .stream()
                .filter(p -> p.getId() != solicitante.getId())
                .collect(toSet());
        this.put(solicitado);
    }

    public Set<Usuario> solicitacoes() {
        Usuario usuario = this.getLogado();
        return usuario.getSolicitacaoamizade();        
    }
}
