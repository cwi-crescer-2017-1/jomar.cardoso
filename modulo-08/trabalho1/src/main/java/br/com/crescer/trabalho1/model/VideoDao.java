/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.trabalho1.model;

import javax.persistence.Id;

/**
 *
 * @author Jomar
 */
public class VideoDao extends CrudDaoImpl<Video, Id>{  
    
    public VideoDao() {
        super(Video.class);
    }
}
