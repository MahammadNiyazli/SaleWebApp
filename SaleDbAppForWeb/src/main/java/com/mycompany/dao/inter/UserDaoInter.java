/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import com.mycompany.entity.User;
import java.util.List;

/**
 *
 * @author User
 */
public interface UserDaoInter {
     public List<User> getAllUser();
     public User getUserById(int id);
     public User findByEmail(String email);
     public boolean addUser(User user);
}
