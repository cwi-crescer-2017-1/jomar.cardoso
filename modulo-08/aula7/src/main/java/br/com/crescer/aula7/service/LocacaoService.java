/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.service;

import br.com.crescer.aula7.model.Genero;
import br.com.crescer.aula7.model.Locacao;
import br.com.crescer.aula7.repository.GeneroRepository;
import br.com.crescer.aula7.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jomar
 */
@Service
public class LocacaoService {
    
    @Autowired
    LocacaoRepository locacaoRepository;
    
    public void post (Locacao locacao) {
        locacaoRepository.save(locacao);
    }
    
    public void delete (Long id) {
        locacaoRepository.delete(id);
    }
    
    public Locacao loadById (Long id) {
        return locacaoRepository.findOne(id);
    }
    
    public Iterable<Locacao> findAll() {
        return locacaoRepository.findAll();
    }
}
