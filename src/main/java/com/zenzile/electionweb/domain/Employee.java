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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author NCUKANE
 */
@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    
    @ManyToOne
    @JoinColumn(name = "id")
    private Station station;
    
    @ManyToOne
    @JoinColumn(name = "id")
    private Position position;

    private Employee() {
    }
    
    private Employee(InnerEmployee i) {
        id = i.id;
        name = i.name;
        surname = i.surname;
        station = i.station;
        position = i.position;
    }
    
    public static class InnerEmployee
    {
        private Long id;
        private String name;
        private String surname;
        private Station station;
        private Position position;
        
        public InnerEmployee(String n)
        {
            this.name = n;
        }
        
        public InnerEmployee id(Long i)
        {
            id = i;
            return this;
        }

        public InnerEmployee surname(String s)
        {
            surname = s;
            return this;
        }
        public InnerEmployee station(Station s)
        {
            station = s;
            return this;
        }
        public InnerEmployee postion(Position p)
        {
            position = p;
            return this;
        }
        
        public InnerEmployee employee(Employee e)
        {
            id = e.getId();
            name = e.getName();
            surname = e.getSurname();
            station = e.getStation();
            position = e.getPosition();
            return this;
        }
        
        public Employee innerEmployee()
        {
            return new Employee(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Station getStation() {
        return station;
    }

    public Position getPosition() {
        return position;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zenzile.electionweb.domain.Employee[ id=" + id + " ]";
    }
    
}
