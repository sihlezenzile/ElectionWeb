/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author sihle
 */
@Entity
public class Province implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "id")
    private List<District> district;
    
    private Province()
    {

    }
    private Province(InnerProvince i)
    {
        id = i.id;
        name = i.name;
        district = i.district;
    }
    public static class InnerProvince
    {
        private Long id;
        private String name;
        private List<District> district;
        
        public InnerProvince(String n)
        {
            this.name = n;
        }
        
        public InnerProvince id(Long i)
        {
            id = i;
            return this;
        }
        
        public InnerProvince district(List<District> d)
        {
            district = d;
            return this;
        }
        
        public InnerProvince province(Province p)
        {
            id = p.getId();
            name = p.getName();
            district = p.getDistrict();
            return this;
        }
        
        public Province innerProvince()
        {
            return new Province(this);
        }
    }

    public String getName() {
        return name;
    }

    public List<District> getDistrict() {
        return district;
    }
    
    public Long getId() {
        return id;
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
        if (!(object instanceof Province)) {
            return false;
        }
        Province other = (Province) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zenzile.electionweb.domain.Province[ id=" + id + " ]";
    }
    
}
