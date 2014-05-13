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
 * @author NCUKANE
 */
@Embeddable
public class Type implements Serializable {
    private String date;
    private String reason;

    public Type() {
    }
    public Type(InnerType in) {
        date = in.date;
        reason = in.reason;
    }

    
    public static class InnerType
    {
        private String date;
        private String reason; 
        
        public InnerType(String r)
        {
            this.reason = r;
        }
        
        public InnerType date(String d)
        {
            date = d;
            return this;
        }
        
        public InnerType type(Type t)
        {
            date = t.getDate();
            reason = t.getReason();
            return this;
        }
        
        public Type innerType()
        {
            return new Type(this);
        }
    }
    public String getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }
    
    
}
