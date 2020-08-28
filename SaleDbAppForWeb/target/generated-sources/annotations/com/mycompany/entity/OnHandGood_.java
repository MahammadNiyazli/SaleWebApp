package com.mycompany.entity;

import com.mycompany.entity.SoldGood;
import com.mycompany.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-28T11:09:33")
@StaticMetamodel(OnHandGood.class)
public class OnHandGood_ { 

    public static volatile SingularAttribute<OnHandGood, String> vahid;
    public static volatile SingularAttribute<OnHandGood, Float> price;
    public static volatile SingularAttribute<OnHandGood, String> name;
    public static volatile SingularAttribute<OnHandGood, Float> count;
    public static volatile SingularAttribute<OnHandGood, Integer> id;
    public static volatile ListAttribute<OnHandGood, SoldGood> soldGoodList;
    public static volatile SingularAttribute<OnHandGood, User> userId;

}