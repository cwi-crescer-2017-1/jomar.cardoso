/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1jpa.model;

import java.io.Serializable;
import java.util.Date;
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
public class Funcionario extends Pessoa{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ")
    @SequenceGenerator(name = "SQ", sequenceName = "SEQ_FUNCIONARIO", allocationSize=1)
    @Basic(optional = false) 
    private long id; 
    
    @Basic(optional = true)
    private double salario;    
                
    @Basic(optional = true)
    private String funcao; 

    public Funcionario(String bairro, String celular, String cidade, String cpf, String email, Date nascimento, String nome, String numeroCasa, String rg, String rua, String telefone) {
        super(bairro, celular, cidade, cpf, email, nascimento, nome, numeroCasa, rg, rua, telefone);
    }

    @Override
    public Serializable getId() {
        return this.id;
    }
    
    
    
}
