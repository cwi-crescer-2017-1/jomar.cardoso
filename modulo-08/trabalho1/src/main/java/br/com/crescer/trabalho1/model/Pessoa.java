/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;

/**
 *
 * @author Jomar
 */
public abstract class Pessoa extends EntidadeBase implements Serializable{
    
    @Basic(optional = false)  
    private String nome;
    
    @Basic (optional = false)
    private String cpf;
    
    @Basic (optional = true)
    private String rg;
    
    @Basic (optional = true)
    private String rua;
    
    @Basic (optional = true)
    private String bairro;
        
    @Basic (optional = true)
    private String cidade;
    
    @Column(name = "NUMERO_CASA") 
    @Basic (optional = true)
    private String numerocasa;
    
    @Basic (optional = true)
    private String email;
    
    @Basic (optional = true)
    private String telefone;
        
    @Basic (optional = false)
    private String celular;
            
    @Basic (optional = true)
    private Date nascimento;
}
