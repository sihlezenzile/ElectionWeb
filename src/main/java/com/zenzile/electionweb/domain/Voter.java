/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author sihle
 */
@Entity
public class Voter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    @Embedded
    private Contact contact;
    @Embedded
    private Address address;
    @OneToOne
    private Station station;

    private Voter() {
        
    }
    private Voter(InnerVoter in) {
        id = in.id;
        name = in.name;
        surname = in.surname;
        contact = in.contact;
        address = in.address;
        station = in.station;
        
    }
    public static class InnerVoter
    {
        private Long id;
        private String name;
        private String surname;
        private Contact contact;
        private Address address;
        private Station station;
        
        public InnerVoter(Contact c)
        {
            this.contact = c;
        }
        public InnerVoter name(String n)
        {
            name = n;
            return this;
        }
        public InnerVoter surname(String s)
        {
            surname = s;
            return this;
        }
        public InnerVoter id(Long i)
        {
            id = i;
            return this;
        }
        public InnerVoter station(Station s)
        {
            station = s;
            return this;
        }
        public InnerVoter address(Address a)
        {
            address = a;
            return this;
        }
        public InnerVoter voter(Voter v)
        {
            id = v.getId();
            name = v.getName();
            surname = v.getSurname();
            station = v.getStation();
            contact = v.getContact();
            address = v.getAddress();
            
            return this;
        }
        
        public Voter innerVoter()
        {
            return new Voter(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }
    
    public Long getId() {
        return id;
    }

    public Station getStation() {
        return station;
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
        if (!(object instanceof Voter)) {
            return false;
        }
        Voter other = (Voter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zenzile.electionweb.domain.Voter[ id=" + id + " ]";
    }
    
}
