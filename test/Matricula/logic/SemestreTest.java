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
public class SemestreTest {
    
    public SemestreTest() {
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
     * Test of getNumero method, of class Semestre.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Semestre instance = null;
        byte expResult = 0;
        byte result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAsignaturas method, of class Semestre.
     */
    @Test
    public void testGetAsignaturas() {
        System.out.println("getAsignaturas");
        Semestre instance = null;
        ArrayList<Asignatura> expResult = null;
        ArrayList<Asignatura> result = instance.getAsignaturas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
