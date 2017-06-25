/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
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
public class Locacao {
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ")
    @SequenceGenerator(name = "SQ", sequenceName = "SEQ_LOCACAO", allocationSize=1)
    @Basic(optional = false) 
    private long id;
    
    @Column(name = "VALOR_TOTAL")
    private double valor;
    
    @ManyToOne
    @JoinColumn(name = "ID")
    @Column(name = "ID_FUNCIONARIO")
    @Basic(optional = true) 
    private Funcionario funcionario;
    
    @ManyToOne
    @JoinColumn(name = "ID")
    @Column(name = "ID_CLIENTE")
    @Basic(optional = true) 
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "ID")
    @Column(name = "ID_VIDEO")
    @Basic(optional = true) 
    private Video video;
    
    @Column(name = "DATA_DEVOLUCAO")
    @Basic(optional = true) 
    private Date dataDevolucao;
}
