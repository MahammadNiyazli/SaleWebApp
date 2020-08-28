/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author User
 */
@Entity
@Table(name = "sold_good")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoldGood.findAll", query = "SELECT s FROM SoldGood s"),
    @NamedQuery(name = "SoldGood.findById", query = "SELECT s FROM SoldGood s WHERE s.id = :id"),
    @NamedQuery(name = "SoldGood.findBySalesDate", query = "SELECT s FROM SoldGood s WHERE s.salesDate = :salesDate"),
    @NamedQuery(name = "SoldGood.findByPrice", query = "SELECT s FROM SoldGood s WHERE s.price = :price"),
    @NamedQuery(name = "SoldGood.findByCount", query = "SELECT s FROM SoldGood s WHERE s.count = :count"),
    @NamedQuery(name = "SoldGood.findByVahid", query = "SELECT s FROM SoldGood s WHERE s.vahid = :vahid")})
public class SoldGood implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sales_date")
    @Temporal(TemporalType.DATE)
    private Date salesDate;
    @Basic(optional = false)
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @Column(name = "count")
    private float count;
    @Basic(optional = false)
    @Column(name = "vahid")
    private String vahid;
    @JoinColumn(name = "on_hand_good_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OnHandGood onHandGoodId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public SoldGood() {
    }

    public SoldGood(Integer id) {
        this.id = id;
    }

    public SoldGood(Integer id, Date salesDate, float price, float count, String vahid) {
        this.id = id;
        this.salesDate = salesDate;
        this.price = price;
        this.count = count;
        this.vahid = vahid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public String getVahid() {
        return vahid;
    }

    public void setVahid(String vahid) {
        this.vahid = vahid;
    }

    public OnHandGood getOnHandGoodId() {
        return onHandGoodId;
    }

    public void setOnHandGoodId(OnHandGood onHandGoodId) {
        this.onHandGoodId = onHandGoodId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof SoldGood)) {
            return false;
        }
        SoldGood other = (SoldGood) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.SoldGood[ id=" + id + " ]";
    }
    
}
