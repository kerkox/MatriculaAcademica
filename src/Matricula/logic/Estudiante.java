/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author atenea
 */
public class Estudiante extends Persona {

    private String codigo;
    private ArrayList<Tabulado> tabulados = new ArrayList<>();
    private ArrayList<Deuda> deudas = new ArrayList<>();

    public Estudiante(String codigo, long identificacion, String nombre, String apellido) {
        super(identificacion, nombre, apellido);
        this.codigo = codigo;
    }
    
    //==================================
    //Metodos Get
    public String getCodigo() {
        return codigo;
    }

    public ArrayList<Tabulado> getTabulados() {
        return tabulados;
    }

    public ArrayList<Deuda> getDeudas() {
        return deudas;
    }
    
    //==================================
    
    //==================================
    //Metodos Add
    
    public void add(Tabulado tabulado){
        this.tabulados.add(tabulado);
    }
    
    public void add(Deuda deuda){
        this.deudas.add(deuda);
    }
    
    //==================================
    
  
  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
