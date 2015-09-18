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
public class CursoTest {
    
    public CursoTest() {
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
     * Test of getGrupo method, of class Curso.
     */
    @Test
    public void testGetGrupo() {
        System.out.println("getGrupo");
        Curso instance = null;
        byte expResult = 0;
        byte result = instance.getGrupo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalCupos method, of class Curso.
     */
    @Test
    public void testGetTotalCupos() {
        System.out.println("getTotalCupos");
        Curso instance = null;
        int expResult = 0;
        int result = instance.getTotalCupos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHorarios method, of class Curso.
     */
    @Test
    public void testGetHorarios() {
        System.out.println("getHorarios");
        Curso instance = null;
        ArrayList<Horario> expResult = null;
        ArrayList<Horario> result = instance.getHorarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalCupos method, of class Curso.
     */
    @Test
    public void testSetTotalCupos() {
        System.out.println("setTotalCupos");
        short totalCupos = 0;
        Curso instance = null;
        instance.setTotalCupos(totalCupos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Curso.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Cupo cupo = null;
        Curso instance = null;
        instance.add(cupo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
