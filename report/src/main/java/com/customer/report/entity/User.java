/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.report.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author  
 */
@Entity
@Table(name = "users")
@XmlRootElement 
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "UserFullName")
    private String userFullName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Basic(optional = false)
    @Column(name = "ShopID")
    private int shopID;
    @Basic(optional = false)
    @Column(name = "ISCashier")
    private int iSCashier;
    @Basic(optional = false)
    @Column(name = "ShopName")
    private String shopName;
    @Basic(optional = false)
    @Column(name = "IsEnable")
    private int isEnable;
    @Basic(optional = false)
    @Column(name = "CanMakeDiscount")
    private int canMakeDiscount;
    @Column(name = "modifiedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Basic(optional = false)
    @Column(name = "viweraccess")
    private int viweraccess; 
    @Column(name = "securitiesgroup")
    private int securitiesgroup;  
    @Column(name = "employeeId")
    private Integer employeeId; 
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String userFullName, String password, Date datecreated, int shopID, int iSCashier, String shopName, int isEnable, int canMakeDiscount, int viweraccess) {
        this.id = id;
        this.username = username;
        this.userFullName = userFullName;
        this.password = password;
        this.datecreated = datecreated;
        this.shopID = shopID;
        this.iSCashier = iSCashier;
        this.shopName = shopName;
        this.isEnable = isEnable;
        this.canMakeDiscount = canMakeDiscount;
        this.viweraccess = viweraccess;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public int getISCashier() {
        return iSCashier;
    }

    public void setISCashier(int iSCashier) {
        this.iSCashier = iSCashier;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    public int getCanMakeDiscount() {
        return canMakeDiscount;
    }

    public void setCanMakeDiscount(int canMakeDiscount) {
        this.canMakeDiscount = canMakeDiscount;
    }

    public int getViweraccess() {
        return viweraccess;
    }

    public void setViweraccess(int viweraccess) {
        this.viweraccess = viweraccess;
    }

    public Integer getEmployeeId() {
    	if(employeeId==null) {
    		return 0;
    	}
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getSecuritiesgroup() {
		return securitiesgroup;
	}

	public void setSecuritiesgroup(int securitiesgroup) {
		this.securitiesgroup = securitiesgroup;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nstyle.pos.entity.Users[ id=" + id + " ]";
    }
    
}
