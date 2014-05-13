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
 * @author NCUKANE
 */
@Entity
public class District implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Station> station;

    private District() {
    }

    private District(InnerDistrict i) {
        id = i.id;
        name = i.name;
        station = (List<Station>) i.station;
    }
    
    public static class InnerDistrict
    {
        private Long id;
        private String name;
        private List<Station> station;
        
        public InnerDistrict(String n)
        {
            this.name = n;
        }
        
        public InnerDistrict id(Long i)
        {
            id = i;
            return this;
        }
        public InnerDistrict station(List<Station> s)
        {
            station = s;
            return this;
        }
        
        public InnerDistrict district(District d)
        {
            id = d.getId();
            name = d.getName();
            station = d.getStation();
            return this;
        }
        
        public District innerDistrict()
        {
            return new District(this);
        }
    }
    
    public String getName() {
        return name;
    }

    public List<Station> getStation() {
        return station;
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
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zenzile.electionweb.domain.District[ id=" + id + " ]";
    }
    
}
