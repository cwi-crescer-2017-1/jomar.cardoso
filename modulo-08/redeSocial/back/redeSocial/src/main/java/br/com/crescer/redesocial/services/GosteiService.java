/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.services;

import br.com.crescer.redesocial.models.Gostei;
import br.com.crescer.redesocial.models.Post;
import br.com.crescer.redesocial.models.Usuario;
import br.com.crescer.redesocial.repositories.GosteiRepository;
import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jomar
 */
@Service
public class GosteiService {
    
    @Autowired
    GosteiRepository gosteiRepository;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PostService postService;
    
    public void post(BigDecimal idPost) {
        Gostei gostei = new Gostei();
        gostei.setUsuario(usuarioService.getLogado());
        gostei.setPost(postService.loadById(idPost));
        gosteiRepository.save(gostei);
    }
    
    public void delete (BigDecimal id) {
        Usuario usuario = usuarioService.getLogado();
        Gostei gostei = gosteiRepository.findByPostAndUsuario(postService.loadById(id), usuario);
        gosteiRepository.delete(gostei);
    }
    
    public Gostei loadById (BigDecimal id) {
        return gosteiRepository.findOne(id);
    }
    
    public Iterable<Gostei> findAll() {
        return gosteiRepository.findAll();
    }
}
