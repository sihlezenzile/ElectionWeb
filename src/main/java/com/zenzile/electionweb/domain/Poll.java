/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
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
public class Poll implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Party> party;
    
    @Column(unique = true)
    @OneToMany
    @JoinColumn(name = "id")
    private List<Voter> voter;

    private Poll() {
    }

    private Poll(InnerPoll in)
    {
        id = in.id;
        party = in.party;
        voter = in.voter;
    }
    
    public static class InnerPoll
    {
        private Long id;
        private List<Party> party;
        private List<Voter> voter;
        
        public InnerPoll(List<Voter> v)
        {
            this.voter = v;
        }
        public InnerPoll party(List<Party> p)
        {
            party = p;
            return this;
        }
        
        public InnerPoll id(Long i)
        {
            id = i;
            return this;
        }
        
        public InnerPoll poll(Poll p)
        {
            id = p.getId();
            party = p.getParty();
            voter = p.getVoter();
            return this;
            
        }
        
        public Poll innerPoll()
        {
            return new Poll(this);
        }
    }
    public List<Party> getParty() {
        return party;
    }

    public List<Voter> getVoter() {
        return voter;
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
        if (!(object instanceof Poll)) {
            return false;
        }
        Poll other = (Poll) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zenzile.electionweb.domain.Poll[ id=" + id + " ]";
    }
    
}
