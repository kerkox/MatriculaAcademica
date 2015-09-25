/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PeriodoTest {
    
    public PeriodoTest() {
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
     * Test of getInicia method, of class Periodo.
     */
    @Test
    public void testGetInicia() {
        System.out.println("getInicia");
        Periodo instance = null;
        Date expResult = null;
        Date result = instance.getInicia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFin method, of class Periodo.
     */
    @Test
    public void testGetFin() {
        System.out.println("getFin");
        Periodo instance = null;
        Date expResult = null;
        Date result = instance.getFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYear method, of class Periodo.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Periodo instance = null;
        int expResult = 0;
        int result = instance.getYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCursos method, of class Periodo.
     */
    @Test
    public void testGetCursos() {
        System.out.println("getCursos");
        Periodo instance = null;
        ArrayList<Curso> expResult = null;
        ArrayList<Curso> result = instance.getCursos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Periodo.
     */
    @Test
    public void testAdd() {
        try {
            System.out.println("add");
            Curso curso = null;
            Periodo instance = null;
            instance.add(curso);
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        } catch (Exception ex) {
            Logger.getLogger(PeriodoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of equals method, of class Periodo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Periodo instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
