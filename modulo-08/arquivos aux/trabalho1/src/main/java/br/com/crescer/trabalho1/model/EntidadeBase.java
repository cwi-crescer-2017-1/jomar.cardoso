/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1.model;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Jomar
 */
public abstract class EntidadeBase implements Entity{
    public abstract Serializable getId();
}
