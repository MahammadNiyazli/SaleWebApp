/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.OnHandGoodDaoInter;
import com.mycompany.entity.OnHandGood;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author User
 */
public class OnHandGoodDaoImpl extends AbstractDao implements OnHandGoodDaoInter {


    @Override
    public OnHandGood getOnHandGoodById(int id) {
        EntityManager em = em();
        OnHandGood good = em.find(OnHandGood.class,id);
        em.close();
        return good;
    }

    @Override
    public List<OnHandGood> getOnHandGoodByUserId(int userId) {
        EntityManager em = em();
        Query query = em.createQuery("select g from OnHandGood g where g.userId=:userId",OnHandGood.class);
        query.setParameter("userId",userId);
        List<OnHandGood> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public boolean addOnHandGood(OnHandGood good) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(good);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeOnHandGood(int id) {
        EntityManager em = em();
        OnHandGood good = em.find(OnHandGood.class,id);
        em.getTransaction().begin();
        em.remove(good);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateOnHandGood(OnHandGood good) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(good);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
