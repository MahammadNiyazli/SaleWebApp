/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author User
 */
public abstract class AbstractDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("salePU");
    
    public EntityManager em(){
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
