/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author sihle
 */
@Entity
public class SpecialVoter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Voter voter;
    @Embedded
    private Type type;
    
    private SpecialVoter()
    {
        
    }
    private SpecialVoter(InnerSpecial in)
    {
        id = in.id;
        voter = in.voter;
        type = in.type;
        
    }
    
    public static class InnerSpecial
    {
        private Long id;
        private Voter voter;
        private Type type;
        
        public InnerSpecial(Long i)
        {
            this.id = i;
        }
        
        public InnerSpecial voter(Voter v)
        {
            voter = v;
            return this;
        }
        
        public InnerSpecial type(Type t)
        {
            type = t;
            return this;
        }
        
        public InnerSpecial specialVoter(SpecialVoter sp)
        {
            id = sp.getId();
            voter = sp.getVoter();
            type = sp.getType();
            return this;
        }
        
        public SpecialVoter innerSpecial()
        {
            return new SpecialVoter(this);
        }
                    
                    
    }
    public Voter getVoter() {
        return voter;
    }

    public Type getType() {
        return type;
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
        if (!(object instanceof SpecialVoter)) {
            return false;
        }
        SpecialVoter other = (SpecialVoter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zenzile.electionweb.domain.SpecialVoter[ id=" + id + " ]";
    }
    
}
