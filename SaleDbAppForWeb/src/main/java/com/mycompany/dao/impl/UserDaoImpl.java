/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author User
 */
public class UserDaoImpl extends AbstractDao implements UserDaoInter{
    

    @Override
    public List<User> getAllUser(){
        EntityManager em = em();
        Query query = em.createQuery("select u from User u",User.class);
        List<User> list = query.getResultList();
        em.close();
        return list;
    }
    
    
    @Override
    public User getUserById(int id){
     EntityManager em = em();
     User u = em.find(User.class, id);
     em.close();
     return u;
    }
    
    @Override
    public User findByEmail(String email){
        EntityManager em = em();
        Query q = em.createNativeQuery("select * from User where email = ?",User.class);
        q.setParameter(1, email);
        List<User> list = q.getResultList();
        if(list.size()==1){
            return list.get(0);
        }
        em.close();
        return null;
    }
    
    public static BCrypt.Hasher crypt = BCrypt.withDefaults();
    
    @Override
    public boolean addUser(User user){
        EntityManager em = em();
        user.setPassword(crypt.hashToString(4, user.getPassword().toCharArray()));
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
