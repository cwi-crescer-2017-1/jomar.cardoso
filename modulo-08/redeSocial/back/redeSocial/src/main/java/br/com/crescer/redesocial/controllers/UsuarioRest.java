/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.controllers;

import br.com.crescer.redesocial.models.Usuario;
import br.com.crescer.redesocial.services.UsuarioService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jomar.cardoso
 */
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRest {
    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping()
    public String post(@RequestBody Usuario usuario) {
        usuarioService.post(usuario);
        return "Ok";
    }
    
    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable BigDecimal id) {
        usuarioService.delete(id);
        return "Ok";
    }
    
    @GetMapping(value = "/{id}")
    public Usuario get(@PathVariable BigDecimal id) {
        return usuarioService.loadById(id);
    }
    
    @ResponseBody
    @GetMapping
    public List<Usuario> list() {
        return (List<Usuario>) usuarioService.findAll();
    }
}
