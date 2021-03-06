/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.controllers;

import br.com.crescer.redesocial.models.Comentario;
import br.com.crescer.redesocial.models.Usuario;
import br.com.crescer.redesocial.services.ComentarioService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jomar
 */
@RestController
@RequestMapping(value = "/comentario")
public class ComentarioRest {
    
    @Autowired
    ComentarioService comentarioService;
    
    @PostMapping(value = "/{id}")
    public void post(@PathVariable BigDecimal id, @RequestBody Comentario comentario) {
        comentarioService.post(id, comentario);
    }
    
}
