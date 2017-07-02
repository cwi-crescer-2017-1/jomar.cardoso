/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.services;

import br.com.crescer.redesocial.models.Amizade;
import br.com.crescer.redesocial.models.Post;
import br.com.crescer.redesocial.models.Usuario;
import br.com.crescer.redesocial.repositories.PostRepository;
import br.com.crescer.redesocial.repositories.UsuarioRepository;
import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author jomar.cardoso
 */
@Service
public class PostService {
     
    @Autowired
    PostRepository postRepository;
    @Autowired
    UsuarioService usuarioService;
    
    public void post (User user, Post post) {
        Usuario usuario = usuarioService.getLogado();
        post.setIdusuario(usuario);
        postRepository.save(post);
    }
    
    public void delete (BigDecimal id) {
        postRepository.delete(id);
    }
    
    public Post loadById (BigDecimal id) {
        return postRepository.findOne(id);
    }
    
    public List<Post> findAll(int pagina) {        
        return postRepository.findByUsuarioInOrderByIdDesc(usuarioService.getLogado().getAmizadeSet(), (Pageable) new PageRequest(pagina, 14));
        //return postRepository.findAll();
    }
}
