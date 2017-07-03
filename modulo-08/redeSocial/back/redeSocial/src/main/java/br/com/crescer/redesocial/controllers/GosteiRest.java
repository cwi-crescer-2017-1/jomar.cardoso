/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.controllers;

import br.com.crescer.redesocial.services.GosteiService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jomar
 */
@RestController
@RequestMapping(value = "/gostei")
public class GosteiRest {
        
    @Autowired
    GosteiService gosteiService;
    
    @PostMapping(value = "/{id}")
    public void post(@PathVariable BigDecimal id) {
        gosteiService.post(id);
    }
}
