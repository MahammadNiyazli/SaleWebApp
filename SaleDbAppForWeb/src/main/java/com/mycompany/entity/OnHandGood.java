/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author User
 */
@Entity
@Table(name = "on_hand_good")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OnHandGood.findAll", query = "SELECT o FROM OnHandGood o"),
    @NamedQuery(name = "OnHandGood.findById", query = "SELECT o FROM OnHandGood o WHERE o.id = :id"),
    @NamedQuery(name = "OnHandGood.findByName", query = "SELECT o FROM OnHandGood o WHERE o.name = :name"),
    @NamedQuery(name = "OnHandGood.findByPrice", query = "SELECT o FROM OnHandGood o WHERE o.price = :price"),
    @NamedQuery(name = "OnHandGood.findByCount", query = "SELECT o FROM OnHandGood o WHERE o.count = :count"),
    @NamedQuery(name = "OnHandGood.findByVahid", query = "SELECT o FROM OnHandGood o WHERE o.vahid = :vahid")})
public class OnHandGood implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @Column(name = "count")
    private Float count;
    @Column(name = "vahid")
    private String vahid;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "onHandGoodId")
    private List<SoldGood> soldGoodList;

    public OnHandGood() {
    }

    public OnHandGood(Integer id) {
        this.id = id;
    }

    public OnHandGood(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getCount() {
        return count;
    }

    public void setCount(Float count) {
        this.count = count;
    }

    public String getVahid() {
        return vahid;
    }

    public void setVahid(String vahid) {
        this.vahid = vahid;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<SoldGood> getSoldGoodList() {
        return soldGoodList;
    }

    public void setSoldGoodList(List<SoldGood> soldGoodList) {
        this.soldGoodList = soldGoodList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OnHandGood)) {
            return false;
        }
        OnHandGood other = (OnHandGood) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.OnHandGood[ id=" + id + " ]";
    }
    
}
