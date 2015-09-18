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
public class HorarioTest {
    
    public HorarioTest() {
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
     * Test of getHoraIncio method, of class Horario.
     */
    @Test
    public void testGetHoraIncio() {
        System.out.println("getHoraIncio");
        Horario instance = null;
        Date expResult = null;
        Date result = instance.getHoraIncio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraFinalizacion method, of class Horario.
     */
    @Test
    public void testGetHoraFinalizacion() {
        System.out.println("getHoraFinalizacion");
        Horario instance = null;
        Date expResult = null;
        Date result = instance.getHoraFinalizacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDia method, of class Horario.
     */
    @Test
    public void testGetDia() {
        System.out.println("getDia");
        Horario instance = null;
        byte expResult = 0;
        byte result = instance.getDia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
