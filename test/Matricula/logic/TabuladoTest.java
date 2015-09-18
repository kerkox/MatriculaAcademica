/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author atenea
 */
public class TabuladoTest {
    
    public TabuladoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMatriculas method, of class Tabulado.
     */
    @Test
    public void testGetMatriculas() {
        System.out.println("getMatriculas");
        Tabulado instance = null;
        ArrayList<Matricula> expResult = null;
        ArrayList<Matricula> result = instance.getMatriculas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPerido method, of class Tabulado.
     */
    @Test
    public void testGetPerido() {
        System.out.println("getPerido");
        Tabulado instance = null;
        Periodo expResult = null;
        Periodo result = instance.getPerido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Tabulado.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Tabulado instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Tabulado.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Tabulado instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
