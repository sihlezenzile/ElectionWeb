/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zenzile.electionweb.test.repository;

import com.zenzile.electionweb.app.conf.ConnectionConfig;
import com.zenzile.electionweb.domain.Party;
import com.zenzile.electionweb.repository.PartyRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author sihle
 */
public class PartyRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private PartyRepository repo;
    
    public PartyRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hellPersono() {}
    @Test
    public void createParty()
    {         
        Long num1 = Long.parseLong("1000");
        Long num2 = Long.parseLong("3000");
        Party part = new Party.InnerParty("DA")
                .name("Democratic Alliance")
                .deputyId(num1)
                .president(num2)
                .innerParty();
         repo.save(part);
         id = part.getId();
         Assert.assertNotNull(part);
    }
    
    //@Test
    
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        //ctx = new AnnotationConfigApplicationContext();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
