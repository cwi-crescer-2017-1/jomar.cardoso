/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1jpa.model;

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
    private String numeroCasa;
    
    @Basic (optional = true)
    private String email;
    
    @Basic (optional = true)
    private String telefone;
        
    @Basic (optional = false)
    private String celular;
            
    @Basic (optional = true)
    private Date nascimento;
    
    public Pessoa (
                    String bairro,
                    String celular,
                    String cidade,
                    String cpf,
                    String email,
                    Date nascimento,
                    String nome,
                    String numeroCasa,
                    String rg,
                    String rua,
                    String telefone
                    ) {
        this.bairro = bairro;
        this.celular = celular;
        this.cidade = cidade;
        this.cpf = cpf;
        this.email = email;
        this.nascimento = nascimento;
        this.nome = nome;
        this.numeroCasa = numeroCasa;
        this.rg = rg;
        this.rua = rua;
        this.telefone = telefone;
    }
}
