/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.repositories;

import br.com.crescer.redesocial.models.Post;
import java.math.BigDecimal;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jomar.cardoso
 */
public interface PostRepository extends CrudRepository<Post, BigDecimal>{

}
