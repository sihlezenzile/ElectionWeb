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
public class Party implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String abbreviation;
    private String name;
    private Long presidentId;
    private Long deputyId;

    public Party() {
    }
    
    public Party(InnerParty inner)
    {
        id = inner.id;
        abbreviation = inner.abbreviation;
        name = inner.name;
        presidentId = inner.presidentId;
        deputyId = inner.deputyId;
    }
    public static class InnerParty
    {
        private Long id;
        private String abbreviation;
        private String name;
        private Long presidentId;
        private Long deputyId;
        
        public InnerParty id(Long value) {
            id = value;
            return this;
        }
        public InnerParty abbreviation(String abbre) {
            abbreviation = abbre;
            return this;
        }

        public InnerParty name(String nm) {
            name = nm;
            return this;
        }
        
        public InnerParty president(Long pre) {
            presidentId = pre;
            return this;
        }
        
        public InnerParty deputyId(Long dep) {
            deputyId = dep;
            return this;
        }
        
        public InnerParty(Party in)
        {
            id = in.getId();
            abbreviation = in.getAbbreviation();
            name = in.getName();
            deputyId = in.getDeputyId();
            presidentId = in.getPresidentId();
        }
    }
    
    public Long getId() {
        return id;
    }
    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public Long getPresidentId() {
        return presidentId;
    }

    public Long getDeputyId() {
        return deputyId;
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
        if (!(object instanceof Party)) {
            return false;
        }
        Party other = (Party) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zenzile.electionweb.domain.Party[ id=" + id + " ]";
    }
    
}
