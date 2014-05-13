/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author sihle
 */
@Embeddable
public class Contact implements Serializable {
    
    private String landline;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cell;

    private Contact() {
    }

    private Contact(InnerContact in) {
        landline = in.landline;
        email = in.email;
        cell = in.cell;
    }
    
    public static class InnerContact
    {
        private String landline;
        private String email;
        private String cell;
        
        public InnerContact(String e)
        {
            this.email = e;
        }
        public InnerContact landline(String l)
        {
            landline = l;
            return this;
        }
        public InnerContact cell(String c)
        {
            cell = c;
            return this;
        }
        public InnerContact contact(Contact c)
        {
            email = c.getEmail();
            landline = c.getLandline();
            cell = c.getCell();
            return this;
        }
        public Contact innerContact()
        {
            return new Contact(this);
        }
    }
            
    public String getLandline() {
        return landline;
    }

    public String getEmail() {
        return email;
    }

    public String getCell() {
        return cell;
    }
    
    
}
