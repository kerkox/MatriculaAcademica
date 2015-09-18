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
public class ProgramaTest {
    
    public ProgramaTest() {
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
     * Test of getCodigo method, of class Programa.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Programa instance = null;
        String expResult = "";
        String result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Programa.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Programa instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJornada method, of class Programa.
     */
    @Test
    public void testGetJornada() {
        System.out.println("getJornada");
        Programa instance = null;
        String expResult = "";
        String result = instance.getJornada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSemestres method, of class Programa.
     */
    @Test
    public void testGetSemestres() {
        System.out.println("getSemestres");
        Programa instance = null;
        ArrayList<Semestre> expResult = null;
        ArrayList<Semestre> result = instance.getSemestres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Programa.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Programa instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
