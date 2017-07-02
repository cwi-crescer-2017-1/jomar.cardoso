/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.repositories;

import br.com.crescer.redesocial.models.Post;
import br.com.crescer.redesocial.models.Usuario;
import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author jomar.cardoso
 */
public interface PostRepository extends PagingAndSortingRepository<Post, BigDecimal>{
    List<Post> findByUsuarioInOrderByIdDesc(Set<Usuario> amizades, Pageable pageable);
}
