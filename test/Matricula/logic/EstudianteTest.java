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
public class EstudianteTest {
    
    Estudiante instance = new Estudiante("14", 12345, "Pol", "cortes");
    public EstudianteTest() {
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
     * Test of getCodigo method, of class Estudiante.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
       try{ 
        String expResult = "";
        String result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       }catch(Exception ex){
        fail("The test case is a prototype.");   
       }
    }

    /**
     * Test of getTabulados method, of class Estudiante.
     */
    @Test
    public void testGetTabulados() {
        System.out.println("getTabulados");
        try{
        ArrayList<Tabulado> expResult = null;
        ArrayList<Tabulado> result = instance.getTabulados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        }catch(Exception ex){
            fail("The test case is a prototype.");    
        }
        
    }

    /**
     * Test of getDeudas method, of class Estudiante.
     */
    @Test
    public void testGetDeudas() {
        System.out.println("getDeudas");
        try{
        ArrayList<Deuda> expResult = null;
        ArrayList<Deuda> result = instance.getDeudas();
        assertEquals(expResult, result);
        
        }catch(Exception ex){
            fail("The test case is a prototype.");    
        }
        
    }

    /**
     * Test of add method, of class Estudiante.
     */
    @Test
    public void testAdd_Tabulado() {
        System.out.println("add");
        try{
        Tabulado tabulado = null;
        
        instance.add(tabulado);
        }catch(Exception ex){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of add method, of class Estudiante.
     */
    @Test
    public void testAdd_Deuda() {
        System.out.println("add");
        try{
        Deuda deuda = null;
        
        instance.add(deuda);
        }catch(Exception ex){
            fail("The test case is a prototype.");    
        }
        
    }

    /**
     * Test of equals method, of class Estudiante.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        try{
        Object obj = null;
        
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        }catch(Exception ex){
            fail("The test case is a prototype.");    
        }
        
    }
    
}
