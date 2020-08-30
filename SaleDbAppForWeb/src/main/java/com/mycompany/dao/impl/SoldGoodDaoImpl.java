package com.mycompany.dao.impl;

import com.mycompany.dao.AbstractDao;
import com.mycompany.dao.inter.SoldGoodDaoInter;
import com.mycompany.entity.OnHandGood;
import com.mycompany.entity.SoldGood;
import com.mycompany.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class SoldGoodDaoImpl extends AbstractDao implements SoldGoodDaoInter {


    @Override
    public SoldGood getSoldGoodById(int id) {
        EntityManager em = em();
        SoldGood good = em.find(SoldGood.class,id);
        em.close();
        return good;
    }
    @Override
    public List<SoldGood> getSoldGoodByUserId(User user) {
        EntityManager em = em();
        Query query = em.createQuery("select sg from SoldGood sg where sg.userId=:user");
        query.setParameter("user",user);

        List<SoldGood> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<SoldGood> getSoldGoodByUserIdAndDate(User user, Date date) {
        EntityManager em = em();
        Query query = em.createQuery("select sg from SoldGood sg where sg.userId=:user and sg.salesDate=:salesDate");
        query.setParameter("user",user);
        query.setParameter("salesDate",date);

        List<SoldGood> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public boolean addSoldGood(SoldGood good) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(good);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeSoldGood(int id) {
        EntityManager em = em();
        SoldGood good = em.find(SoldGood.class,id);
        em.getTransaction().begin();
        em.remove(good);
        em.getTransaction().commit();
        em.close();
        return true;

    }

    @Override
    public boolean updateSoldGood(SoldGood good) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(good);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
