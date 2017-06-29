/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.controller;

import br.com.crescer.aula7.model.Funcionario;
import br.com.crescer.aula7.model.Genero;
import br.com.crescer.aula7.service.FuncionarioService;
import br.com.crescer.aula7.service.GeneroService;
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
 * @author Jomar
 */

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioRest {
    
    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping()
    public String post(@RequestBody Funcionario funcionario) {
        funcionarioService.post(funcionario);
        return "Ok";
    }
    
    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {
        funcionarioService.delete(id);
        return "Ok";
    }
    
    @GetMapping(value = "/{id}")
    public Funcionario get(@PathVariable Long id) {
        return funcionarioService.loadById(id);
    }
    
    @ResponseBody
    @GetMapping
    public List<Funcionario> list() {
        return (List<Funcionario>) funcionarioService.findAll();
    }
    
}
