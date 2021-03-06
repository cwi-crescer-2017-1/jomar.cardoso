/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.repositories;

import br.com.crescer.redesocial.models.Usuario;
import java.math.BigDecimal;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jomar.cardoso
 */
public interface UsuarioRepository extends CrudRepository<Usuario, BigDecimal> {

    Usuario findByEmail(String email);

//    public Set<Usuario> findByUsuarioNotIn(Set<BigDecimal> ids);

    //public Set<Usuario> findAllNotIn(Set<Usuario> usuarios);



    public Set<Usuario> findByIdNotIn(Set<BigDecimal> ids);
}
