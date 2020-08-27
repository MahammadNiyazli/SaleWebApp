/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.SoldGood;

import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public interface SoldGoodDaoInter {

    public List<SoldGood> getSoldGoodByUserId(int userId);

    public List<SoldGood> getSoldGoodByUserIdAndDate(int userId, Date date);

    public boolean addSoldGood(SoldGood good);

    public boolean removeSoldGood(int id);

    public boolean updateSoldGood(SoldGood good);
}
