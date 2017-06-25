/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Jomar
 */

@Entity
class Genero {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ")
    @SequenceGenerator(name = "SQ", sequenceName = "SEQ_GENERO", allocationSize=1)
    @Basic(optional = false) 
    private long id; 
    
    @Basic(optional = false)
    private String descricao;
}
