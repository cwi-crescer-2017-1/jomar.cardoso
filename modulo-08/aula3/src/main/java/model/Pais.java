/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jomar.cardoso
 */
public class Pais {
    
    private long id;
    private String nome;
    private String sigla;
    
    public Pais(){}
    
    public Pais(long id, String nome, String sigla){
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    
}
