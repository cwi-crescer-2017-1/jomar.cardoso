/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.redesocial.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jomar.cardoso
 */
@Entity
@Table(name = "SOLICITACAOAMIZADE")
@NamedQueries({
    @NamedQuery(name = "Solicitacaoamizade.findAll", query = "SELECT s FROM Solicitacaoamizade s")})
public class Solicitacaoamizade implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private static final String SEQUENCE_NAME = "sq_SolicitacaoAmizade";
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "IDSOLICITANTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idsolicitante;
    @JoinColumn(name = "IDSOLICITADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idsolicitado;

    public Solicitacaoamizade() {
    }

    public Solicitacaoamizade(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Usuario getIdsolicitante() {
        return idsolicitante;
    }

    public void setIdsolicitante(Usuario idsolicitante) {
        this.idsolicitante = idsolicitante;
    }

    public Usuario getIdsolicitado() {
        return idsolicitado;
    }

    public void setIdsolicitado(Usuario idsolicitado) {
        this.idsolicitado = idsolicitado;
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
        if (!(object instanceof Solicitacaoamizade)) {
            return false;
        }
        Solicitacaoamizade other = (Solicitacaoamizade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.redesocial.Solicitacaoamizade[ id=" + id + " ]";
    }
    
}
