/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.util.Date;
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
public class MatriculaTest {
    
    public MatriculaTest() {
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
     * Test of getMatriculada method, of class Matricula.
     */
    @Test
    public void testGetMatriculada() {
        System.out.println("getMatriculada");
        Matricula instance = null;
        Date expResult = null;
        Date result = instance.getMatriculada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCancelada method, of class Matricula.
     */
    @Test
    public void testGetCancelada() {
        System.out.println("getCancelada");
        Matricula instance = null;
        Date expResult = null;
        Date result = instance.getCancelada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurso method, of class Matricula.
     */
    @Test
    public void testGetCurso() {
        System.out.println("getCurso");
        Matricula instance = null;
        Curso expResult = null;
        Curso result = instance.getCurso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCancelada method, of class Matricula.
     */
    @Test
    public void testSetCancelada() {
        System.out.println("setCancelada");
        Date cancelada = null;
        Matricula instance = null;
        instance.setCancelada(cancelada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
