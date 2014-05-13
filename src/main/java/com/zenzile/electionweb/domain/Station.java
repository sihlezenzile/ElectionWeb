/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sihle
 */
@Entity
public class Station implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;

    private Station() {
    }
    
    private Station(InnerStation in) {
        id = in.id;
        name = in.name;
        
        
    }
    
    public static class InnerStation
    {
        private Long id;

        private String name;
        
        public InnerStation(String n)
        {
            this.name = n;
        }
        
        public InnerStation name(String n)
        {
            name = n;
            return this;
        }
        
        public InnerStation id(Long i)
        {
            id = i;
            return this;
        }
        
        
        
        public InnerStation innerStation(Station st)
        {
            name = st.getName();
            id = st.getId();
            return this;
        }
        
        public Station station()
        {
            return new Station(this);
        }
    }

    public String getName() {
        return name;
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
        if (!(object instanceof Station)) {
            return false;
        }
        Station other = (Station) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zenzile.electionweb.domain.Station[ id=" + id + " ]";
    }
    
}
