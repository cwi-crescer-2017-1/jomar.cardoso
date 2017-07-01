/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.services;

import br.com.crescer.redesocial.models.Post;
import br.com.crescer.redesocial.models.Usuario;
import br.com.crescer.redesocial.repositories.PostRepository;
import br.com.crescer.redesocial.repositories.UsuarioRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public void post (Post post) {
        postRepository.save(post);
    }
    
    public void delete (BigDecimal id) {
        postRepository.delete(id);
    }
    
    public Post loadById (BigDecimal id) {
        return postRepository.findOne(id);
    }
    
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }
}
