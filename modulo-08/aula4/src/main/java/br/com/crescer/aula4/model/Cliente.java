/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.model;

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
public class Cliente extends Pessoa{
     
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ")
    @SequenceGenerator(name = "SQ", sequenceName = "SEQ_CLIENTE", allocationSize=1)
    @Basic(optional = false) 
    private long id;

    public Cliente(String bairro, String celular, String cidade, String cpf, String email, Date nascimento, String nome, String numeroCasa, String rg, String rua, String telefone) {
        super(bairro, celular, cidade, cpf, email, nascimento, nome, numeroCasa, rg, rua, telefone);
    }

    @Override
    public Serializable getId() {
        return this.id;
    }

}
 

