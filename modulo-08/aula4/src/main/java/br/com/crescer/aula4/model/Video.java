/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.model;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Jomar
 */

@Entity
public class Video extends EntidadeBase implements  Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ")
    @SequenceGenerator(name = "SQ", sequenceName = "SEQ_VIDEO", allocationSize=1)
    @Basic(optional = false) 
    private long id; 
     
    @Basic(optional = false)
    private double valor;
    
    @Basic(optional = true)
    private String duracao;
    
    @ManyToOne
    @JoinColumn(name = "ID")
    @Column(name = "ID_GENERO") 
    @Basic(optional = true)
    private Genero genero;
        
    @Basic(optional = true)
    private String nome;
            
    @Basic(optional = true)
    private int quantidade;
                
    @Basic(optional = true)
    @Column(name = "DATA_LANCAMENTO") 
    private Date dataLancamento;

    @Override
    public Serializable getId() {
        return this.id;
    }
}
