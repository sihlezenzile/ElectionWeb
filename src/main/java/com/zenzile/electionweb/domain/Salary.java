/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author sihle
 */
@Embeddable
public class Salary implements Serializable {
    
    private String type;
    private double bonus;
    private double amount;

    private Salary() {
    }
    
    private Salary(InnerSalary in)
    {
        type = in.type;
        bonus = in.bonus;
        amount = in.amount;
    }
    
    public static class InnerSalary
    {
        private String type;
        private double bonus;
        private double amount;
        
        public InnerSalary(String t)
        {
            this.type = t;
        }
        
         public InnerSalary salary(Salary in)
        {
            type = in.getType();
            bonus = in.getBonus();
            amount = in.getAmount();
            return this;
        }
        public InnerSalary type(String t)
        {
            type = t;
            return this;
        }
        
        public InnerSalary bonus(double b)
        {
            bonus = b;
            return this;
            
        }
        
        public InnerSalary amount(double a)
        {
            amount = a;
            return this;
        }
       
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.type);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.bonus) ^ (Double.doubleToLongBits(this.bonus) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salary other = (Salary) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bonus) != Double.doubleToLongBits(other.bonus)) {
            return false;
        }
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount)) {
            return false;
        }
        return true;
    }

    
    
    public String getType() {
        return type;
    }

    public double getBonus() {
        return bonus;
    }

    public double getAmount() {
        return amount;
    }
    
    
}
