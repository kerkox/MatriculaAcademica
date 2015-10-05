/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Polker
 */
@Entity
public class Docente extends Persona{
    
    @Column(nullable = false, length = 80)
    private String profesion;

    public Docente() {
    }

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
    //Metodos Set
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
    //==============================
    
    
    
}
