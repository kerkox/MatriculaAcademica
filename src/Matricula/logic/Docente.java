/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

/**
 *
 * @author atenea
 */
public class Docente extends Persona{
    
    private String profesion;

    public Docente(String profesion, long identificacion, String nombre, String apellido) {
        super(identificacion, nombre, apellido);
        this.profesion = profesion;
    }

    //==============================
    //Metodos Get
    public String getProfesion() {
        return profesion;
    }
    //==============================
    
    
    
    
    
}
