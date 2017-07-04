/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.repositories;

import br.com.crescer.redesocial.models.Post;
import br.com.crescer.redesocial.models.Usuario;
import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author jomar.cardoso
 */
public interface PostRepository extends PagingAndSortingRepository<Post, BigDecimal> {
    //@Query("SELECT *  FROM Post WHERE Idusuario = :#{#amizades.id} ORDER BY Id Desc")
    //Page<Post> findByUsuarioIn(@Param("amizades") Set<Usuario> amizades, Pageable pageable);

    //Page<Post> findByUsuarioIn(@Param("amizades") Set<Usuario> amizades, PageRequest pageable);
    //public Page<Post> findByUsuarioIn(Set<Usuario> amizades, PageRequest pageRequest);
    Page<Post> findByUsuario(Usuario amigo, Pageable pageable);
    Page<Post> findByUsuario_idIn(Set<BigDecimal> ids, Pageable pageable);

}
