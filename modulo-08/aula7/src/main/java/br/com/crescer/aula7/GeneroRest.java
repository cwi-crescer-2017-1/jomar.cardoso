/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "/current_date_time")
    public Date date() {
        return new Date();
    }
    
//    @RequestMapping(value = "/todos");
    @GetMapping
    public List<Genero> list() {
        return (List<Genero>) generoService.todos();
    }
}