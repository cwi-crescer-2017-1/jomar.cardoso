/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Jomar
 */
@Entity 
public class Cliente {
 
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ")
    @SequenceGenerator(name = "SQ", sequenceName = "SQCLIENTE", allocationSize=1)
    @Basic(optional = false) 
    @Column(name = "ID_CLIENTE") 
    private int id; 
 
    @Basic(optional = false) 
    @Column(name = "NM_CLIENTE") 
    private String nome;
 
    public Cliente() { 

    }
 
    public Cliente(String nome) { 
        this.nome = nome;
    }
 

 
    public Cliente(int id, String nome) { 
        this.id = id; 
        this.nome = nome; 
    }
    
    public int getId() { 
        return id; 
    }
 

 
    public void setId(int id) { 
        this.id = id; 
    }
 
 
    public String getNome() { 
        return nome; 
    }
 

 
    public void setNome(String nome) { 
        this.nome = nome; 
    }
  
}
 