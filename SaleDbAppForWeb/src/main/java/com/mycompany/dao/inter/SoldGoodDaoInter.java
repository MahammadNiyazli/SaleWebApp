/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.SoldGood;
import com.mycompany.entity.User;

import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public interface SoldGoodDaoInter {

    public List<SoldGood> getSoldGoodByUserId(User user);

    public List<SoldGood> getSoldGoodByUserIdAndDate(User user, Date date);

    public boolean addSoldGood(SoldGood good);

    public boolean removeSoldGood(int id);

    public boolean updateSoldGood(SoldGood good);
}
