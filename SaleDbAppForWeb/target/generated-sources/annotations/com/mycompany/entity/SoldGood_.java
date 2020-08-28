package com.mycompany.entity;

import com.mycompany.entity.OnHandGood;
import com.mycompany.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-28T17:52:38")
@StaticMetamodel(SoldGood.class)
public class SoldGood_ { 

    public static volatile SingularAttribute<SoldGood, String> vahid;
    public static volatile SingularAttribute<SoldGood, Date> salesDate;
    public static volatile SingularAttribute<SoldGood, Float> price;
    public static volatile SingularAttribute<SoldGood, Float> count;
    public static volatile SingularAttribute<SoldGood, Integer> id;
    public static volatile SingularAttribute<SoldGood, OnHandGood> onHandGoodId;
    public static volatile SingularAttribute<SoldGood, User> userId;

}