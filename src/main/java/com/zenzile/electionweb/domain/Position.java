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

/**
 *
 * @author sihle
 */
@Entity
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullname;
    private String acronym;
    
    @Embedded
   private Salary salary;
    



    public Position() {
    }
    
    private Position(InnerPosition in)
    {
        id = in.id;
        fullname = in.fullname;
        acronym = in.acronym;
        salary = in.salary;
    }

    public static class InnerPosition
    {
        private Long id;
        private String fullname;
        private String acronym;
        private Salary salary;
        
        public InnerPosition id(Long i)
        {
            id = i;
            return this;
        }
        
        public InnerPosition fullname(String f)
        {
            fullname = f;
            return this;
        }
        
        public InnerPosition(String a)
        {
            this.acronym = a;
        }
        
        public InnerPosition salary(Salary s)
        {
            salary = s;
            return this;
        }
        
        public InnerPosition position(Position in)
        {
            id = in.getId();
            fullname = in.getFullname();
            acronym = in.getAcronym();
            salary = in.getSalary();
            
            return this;
        }
        
        public Position innerPosition()
        {
            return new Position(this);
        }
    }
    
    public String getFullname() {
        return fullname;
    }

    public String getAcronym() {
        return acronym;
    }

    public Salary getSalary() {
        return salary;
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
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zenzile.electionweb.domain.Position[ id=" + id + " ]";
    }
    
}
