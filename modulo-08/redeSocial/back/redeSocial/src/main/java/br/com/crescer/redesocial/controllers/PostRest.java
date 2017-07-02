/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.controllers;

import br.com.crescer.redesocial.models.Post;
import br.com.crescer.redesocial.services.PostService;
import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jomar
 */
@RestController
@RequestMapping(value = "/postagem")
public class PostRest {
    @Autowired
    PostService postService;
    
    @PostMapping()
    public Post post(@AuthenticationPrincipal User user, @RequestBody Post postagem) {
        postService.post(user, postagem);
        return postagem;
    }
    
    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable BigDecimal id) {
        postService.delete(id);
        return "Ok";
    }
    
    @GetMapping(value = "/{id}")
    public Post get(@PathVariable BigDecimal id) {
        return postService.loadById(id);
    }
    
//    @ResponseBody
//    @GetMapping
//    public List<Post> list() {
//        return (List<Post>) postService.findAll();
//    }  
    
    @GetMapping
    public List<Post> getFeedPosts(@AuthenticationPrincipal User user, Pageable pageable) {
        return postService.findAll(user, pageable);
    }
}
