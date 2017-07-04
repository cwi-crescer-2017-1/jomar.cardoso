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
    private Set<Gostei> gostei;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Set<Post> post;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Set<Comentario> comentario;
   
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> amigo;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> solicitacaoamizade;

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

    public Set<Gostei> getGostei() {
        return gostei;
    }

    public void setGostei(Set<Gostei> gostei) {
        this.gostei = gostei;
    }

    public Set<Post> getPost() {
        return post;
    }

    public void setPost(Set<Post> post) {
        this.post = post;
    }

    public Set<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(Set<Comentario> comentario) {
        this.comentario = comentario;
    }

    public Set<Usuario> getAmigo() {
        return amigo;
    }

    public void setAmigo(Set<Usuario> amigo) {
        this.amigo = amigo;
    }

    public Set<Usuario> getSolicitacaoamizade() {
        return solicitacaoamizade;
    }

    public void setSolicitacaoamizade(Set<Usuario> solicitacaoamizade) {
        this.solicitacaoamizade = solicitacaoamizade;
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
