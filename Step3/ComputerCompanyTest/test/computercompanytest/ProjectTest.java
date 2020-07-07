/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computercompanytest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
 */
public class ProjectTest {
    private Project instance;
    
    public ProjectTest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
    
    @Before
    public void setUp() {
        System.out.println("Setting it up!");
        instance = new Project(1,"abc",100);
    }
    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of setId method, of class Project.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int s = instance.getId();
        assertEquals(1,s);
    }

    /**
     * Test of getId method, of class Project.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int result = instance.getId();
        assertEquals(1, result);
       
    }

    /**
     * Test of setName method, of class Project.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String s = "abc";
        instance.setName(s);
        assertEquals(s, instance.getName());

    }

    /**
     * Test of getName method, of class Project.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "abc";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBudget method, of class Project.
     */
    @Test
    public void testSetBudget() {
        System.out.println("setBudget");
        int d = 0;
        instance.setBudget(d);
        assertEquals(d,instance.getBudget());
    }

    /**
     * Test of getBudget method, of class Project.
     */
    @Test
    public void testGetBudget() {
        System.out.println("getBudget");
        int expResult = 0;
        instance.setBudget(expResult);
        int result = instance.getBudget();
        assertEquals(expResult, result);
    }
    
}
