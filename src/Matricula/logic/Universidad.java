/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.util.ArrayList;

/**
 *
 * @author atenea
 */
public class Universidad {
    
    private String nit;
    private String nombre;
    private String direccion;
    private Periodo peridoActual;
    private ArrayList<Periodo> periodos = new ArrayList<>();
    private ArrayList<Programa> programas = new ArrayList<>();
    private ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private ArrayList<Docente> docentes = new ArrayList<>();
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public Universidad(String nit, String nombre, String direccion, Periodo peridoActual) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.peridoActual = peridoActual;
    }

    
    //==============================
    //Metodos Get
    public String getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Periodo getPeridoActual() {
        return peridoActual;
    }

    public ArrayList<Periodo> getPeriodos() {
        return periodos;
    }

    public ArrayList<Programa> getProgramas() {
        return programas;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    //==============================
            
    
    
}
