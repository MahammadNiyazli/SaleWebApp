package com.mycompany.dao.impl;

import com.mycompany.dao.inter.SoldGoodDaoInter;
import com.mycompany.entity.SoldGood;

import java.util.Date;
import java.util.List;

public class SoldGoodDaoImpl implements SoldGoodDaoInter {
    @Override
    public List<SoldGood> getSoldGoodByUserId(int userId) {
        return null;
    }

    @Override
    public List<SoldGood> getSoldGoodByUserIdAndDate(int userId, Date date) {
        return null;
    }

    @Override
    public boolean addSoldGood(SoldGood good) {
        return false;
    }

    @Override
    public boolean removeSoldGood(int id) {
        return false;
    }

    @Override
    public boolean updateSoldGood(SoldGood good) {
        return false;
    }
}
