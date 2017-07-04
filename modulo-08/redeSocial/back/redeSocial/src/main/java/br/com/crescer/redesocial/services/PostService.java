/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.services;

import br.com.crescer.redesocial.models.Post;
import br.com.crescer.redesocial.models.Usuario;
import br.com.crescer.redesocial.repositories.PostRepository;
import java.math.BigDecimal;
import java.util.Set;
import static java.util.stream.Collectors.toSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public void post(Post post) {
        Usuario usuario = usuarioService.getLogado();
        post.setUsuario(usuario);
        postRepository.save(post);
    }

    public void delete(BigDecimal id) {
        postRepository.delete(id);
    }

    public Post loadById(BigDecimal id) {
        return postRepository.findOne(id);
    }

    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Page<Post> findAll(int pagina) {
        final Usuario logado = usuarioService.getLogado();
        final Set<BigDecimal> ids = logado.getAmigo().stream()
                .map(Usuario::getId)
                .collect(toSet());
        ids.add(logado.getId());

        return postRepository.findByUsuario_idIn(ids, new PageRequest(pagina, 14));
        //Usuario amigo = usuarioService.getLogado().getAmizadeSet().;
        //Page<Post> postagens = postRepository.findByUsuario(amizades, new PageRequest(pagina, 14));
//        Page<Post> postagens = postRepository.findByUsuario(usuarioService.getLogado(), new PageRequest(pagina, 14));
//        return postagens;

    }

}
