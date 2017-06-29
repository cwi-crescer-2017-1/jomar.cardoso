/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.service;

import br.com.crescer.aula7.model.Cliente;
import br.com.crescer.aula7.model.Genero;
import br.com.crescer.aula7.repository.ClienteRepository;
import br.com.crescer.aula7.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jomar
 */
@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
    
    public void post (Cliente cliente) {
        clienteRepository.save(cliente);
    }
    
    public void delete (Long id) {
        clienteRepository.delete(id);
    }
    
    public Cliente loadById (Long id) {
        return clienteRepository.findOne(id);
    }
    
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
