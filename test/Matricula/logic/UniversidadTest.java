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
public class UniversidadTest {
    
    public UniversidadTest() {
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
     * Test of getNit method, of class Universidad.
     */
    @Test
    public void testGetNit() {
        System.out.println("getNit");
        Universidad instance = null;
        String expResult = "";
        String result = instance.getNit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Universidad.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Universidad instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class Universidad.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Universidad instance = null;
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeridoActual method, of class Universidad.
     */
    @Test
    public void testGetPeridoActual() {
        System.out.println("getPeridoActual");
        Universidad instance = null;
        Periodo expResult = null;
        Periodo result = instance.getPeridoActual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeriodos method, of class Universidad.
     */
    @Test
    public void testGetPeriodos() {
        System.out.println("getPeriodos");
        Universidad instance = null;
        ArrayList<Periodo> expResult = null;
        ArrayList<Periodo> result = instance.getPeriodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProgramas method, of class Universidad.
     */
    @Test
    public void testGetProgramas() {
        System.out.println("getProgramas");
        Universidad instance = null;
        ArrayList<Programa> expResult = null;
        ArrayList<Programa> result = instance.getProgramas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAsignaturas method, of class Universidad.
     */
    @Test
    public void testGetAsignaturas() {
        System.out.println("getAsignaturas");
        Universidad instance = null;
        ArrayList<Asignatura> expResult = null;
        ArrayList<Asignatura> result = instance.getAsignaturas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocentes method, of class Universidad.
     */
    @Test
    public void testGetDocentes() {
        System.out.println("getDocentes");
        Universidad instance = null;
        ArrayList<Docente> expResult = null;
        ArrayList<Docente> result = instance.getDocentes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstudiantes method, of class Universidad.
     */
    @Test
    public void testGetEstudiantes() {
        System.out.println("getEstudiantes");
        Universidad instance = null;
        ArrayList<Estudiante> expResult = null;
        ArrayList<Estudiante> result = instance.getEstudiantes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
