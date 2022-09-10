package com.mycompany.Main;

import com.mycompany.dao.impl.OnHandGoodDaoImpl;
import com.mycompany.dao.impl.SoldGoodDaoImpl;
import com.mycompany.dao.impl.UserDaoImpl;
import com.mycompany.dao.inter.OnHandGoodDaoInter;
import com.mycompany.dao.inter.SoldGoodDaoInter;
import com.mycompany.dao.inter.UserDaoInter;

public class Context {

    
    
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }

    public static OnHandGoodDaoInter instanceOnHandGoodDao(){
        System.out.println("hello world");
        return new OnHandGoodDaoImpl();
    }

    public static SoldGoodDaoInter instanceSoldGoodDao(){
        return new SoldGoodDaoImpl();
    }
}
