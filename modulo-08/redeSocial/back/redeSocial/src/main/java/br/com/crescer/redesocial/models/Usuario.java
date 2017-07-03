/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jomar.cardoso
 */
@Entity
@Table(name = "USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    private static final String SEQUENCE_NAME = "sq_Usuario";
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 100)
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "SEXO")
    private Character sexo;
    
    @Column(name = "DATADENASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datadenascimento;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    
    @Column(name = "SENHA")
    private String senha;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Set<Gostei> gosteiSet;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Set<Post> postSet;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Set<Comentario> comentarioSet;
    
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsolicitante")
//    private Set<Solicitacaoamizade> solicitacaoamizadeSet;
    
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsolicitado")
//    private Set<Solicitacaoamizade> solicitacaoamizadeSet1;
    
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
//    private Set<Amizade> amizadeSet;
    
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idamigo")
//    private Set<Amizade> amizadeSet1;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> amizadeSet;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> solicitacaoamizadeSet;

    public Usuario() {
    }

    public Usuario(BigDecimal id) {
        this.id = id;
    }

    public Usuario(BigDecimal id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getDatadenascimento() {
        return datadenascimento;
    }

    public void setDatadenascimento(Date datadenascimento) {
        this.datadenascimento = datadenascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Gostei> getGosteiSet() {
        return gosteiSet;
    }

    public void setGosteiSet(Set<Gostei> gosteiSet) {
        this.gosteiSet = gosteiSet;
    }

    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }

    public Set<Comentario> getComentarioSet() {
        return comentarioSet;
    }

    public void setComentarioSet(Set<Comentario> comentarioSet) {
        this.comentarioSet = comentarioSet;
    }

//    public Set<Solicitacaoamizade> getSolicitacaoamizadeSet() {
//        return solicitacaoamizadeSet;
//    }
//
//    public void setSolicitacaoamizadeSet(Set<Solicitacaoamizade> solicitacaoamizadeSet) {
//        this.solicitacaoamizadeSet = solicitacaoamizadeSet;
//    };
//
//    public Set<Solicitacaoamizade> getSolicitacaoamizadeSet1() {
//        return solicitacaoamizadeSet1;
//    }
//
//    public void setSolicitacaoamizadeSet1(Set<Solicitacaoamizade> solicitacaoamizadeSet1) {
//        this.solicitacaoamizadeSet1 = solicitacaoamizadeSet1;
//    }
//
//    public Set<Amizade> getAmizadeSet() {
//        return amizadeSet;
//    }
//
//    public void setAmizadeSet(Set<Amizade> amizadeSet) {
//        this.amizadeSet = amizadeSet;
//    }
//
//    public Set<Amizade> getAmizadeSet1() {
//        return amizadeSet1;
//    }
//
//    public void setAmizadeSet1(Set<Amizade> amizadeSet1) {
//        this.amizadeSet1 = amizadeSet1;
//    }
    
     public Set<Usuario> getAmizadeSet() {
        return amizadeSet;
    }
     
    public void setAmizadeSet(Set<Usuario> amizades) {
        this.amizadeSet = amizades;
    }
    
    public Set<Usuario> getSolicitacaoamizadeSet() {
        return solicitacaoamizadeSet;
    }

    public void setSolicitacaoamizadeSet(Set<Usuario> solicitacaoamizadeSet) {
        this.solicitacaoamizadeSet = solicitacaoamizadeSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.redesocial.Usuario[ id=" + id + " ]";
    }
    
}
