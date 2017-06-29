/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.service.GeneroService;
import br.com.crescer.aula7.model.Genero;
import java.util.Date;
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
@RequestMapping(value = "/genero")
public class GeneroRest {
    
    @Autowired
    GeneroService generoService;

    @PostMapping()
    public String post(@RequestBody Genero genero) {
        generoService.post(genero);
        return "Ok";
    }
    
    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {
        generoService.delete(id);
        return "Ok";
    }
    
    @GetMapping(value = "/{id}")
    public Genero get(@PathVariable Long id) {
        return generoService.loadById(id);
    }
    
    @ResponseBody
    @GetMapping
    public List<Genero> list() {
        return (List<Genero>) generoService.findAll();
    }
}