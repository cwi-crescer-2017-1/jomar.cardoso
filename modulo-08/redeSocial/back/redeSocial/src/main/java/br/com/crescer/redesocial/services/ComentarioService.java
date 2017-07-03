/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.services;

import br.com.crescer.redesocial.models.Comentario;
import br.com.crescer.redesocial.repositories.ComentarioRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jomar
 */
@Service
public class ComentarioService {
    
    @Autowired
    ComentarioRepository comentarioRepository;
    
    @Autowired
    PostService postService;
    
    @Autowired
    UsuarioService usuarioService;
    
    public void post(BigDecimal idPost, Comentario comentario){
        comentario.setIdpost(postService.loadById(idPost));
        comentario.setUsuario(usuarioService.getLogado());
        comentarioRepository.save(comentario);
    }
    
    
    
}
