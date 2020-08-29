package com.mycompany.entity;

import com.mycompany.entity.OnHandGood;
import com.mycompany.entity.SoldGood;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-29T21:11:22")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> place;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile ListAttribute<User, SoldGood> soldGoodList;
    public static volatile ListAttribute<User, OnHandGood> onHandGoodList;
    public static volatile SingularAttribute<User, String> email;

}