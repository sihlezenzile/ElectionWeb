/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author sihle
 */
@Embeddable
public class Address implements Serializable {
     
    private int number;
    private String street;
    private String poscode;
    private String suburb;

    private Address() {
    }
    private Address(InnerAddress in)
    {
        number = in.number;
        street = in.street;
        poscode = in.poscode;
        suburb = in.suburb;
    }

    public static class InnerAddress
    {
        private int number;
        private String street;
        private String poscode;
        private String suburb;
        
        public InnerAddress(int n)
        {
            this.number = n;
        }
        public InnerAddress street(String s)
        {
            street = s;
            return this;
        }
        public InnerAddress poscode(String p)
        {
            poscode = p;
            return this;
        }
        public InnerAddress suburb(String b)
        {
            suburb = b;
            return this;
        }
        
        public InnerAddress contact(Address a)
        {
            number = a.getNumber();
            street =a.getStreet();
            poscode = a.getPoscode();
            suburb = a.getSuburb();
            
            return this;
        }
        public Address innerAddress()
        {
            return new Address(this);
        }
    }
    
    public int getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getPoscode() {
        return poscode;
    }

    public String getSuburb() {
        return suburb;
    }
    
    
    
}
