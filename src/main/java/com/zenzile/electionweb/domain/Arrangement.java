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
public class Arrangement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name = "id")
    @OneToMany
    List<Poll> poll;
    private int numVotes;
    private static final int sits = 400;

    public List<Poll> getPoll() {
        return poll;
    }

    private Arrangement() {
    }

    private Arrangement(InnerArrange in) {
        id = in.id;
        poll = in.poll;
        numVotes = in.numVotes;
    }
    
    public static class InnerArrange
    {
        private Long id;
        List<Poll> poll;
        private int numVotes;
        
        public InnerArrange(int v)
        {
            this.numVotes = v;
        }
        
        public InnerArrange poll(List<Poll> p)
        {
            poll = p;
            return this;
        }
        
        public InnerArrange id(Long i)
        {
            id = i;
            return this;
        }
        
        public InnerArrange poll(Arrangement ar)
        {
            id = ar.getId();
            poll = ar.getPoll();
            numVotes = ar.getNumVotes();
            return this;
        }
        
        public Arrangement innerArrange()
        {
            return new Arrangement(this);
        }
    }
    public int getNumVotes() {
        return numVotes;
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
        if (!(object instanceof Arrangement)) {
            return false;
        }
        Arrangement other = (Arrangement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zenzile.electionweb.domain.Arrangement[ id=" + id + " ]";
    }
    
}
