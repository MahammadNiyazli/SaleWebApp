/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.OnHandGood;
import com.mycompany.entity.User;

import java.util.List;

/**
 *
 * @author User
 */
public interface OnHandGoodDaoInter {
    public OnHandGood getOnHandGoodById(int id);

    public List<OnHandGood> getOnHandGoodByUserId(User user);

    public boolean addOnHandGood(OnHandGood good);

    public boolean removeOnHandGood(int id);

    public boolean updateOnHandGood(OnHandGood good);
}
