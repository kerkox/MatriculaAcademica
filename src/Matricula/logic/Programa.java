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
public class Programa {
    private String codigo;
    private String nombre;
    private String jornada;
    private ArrayList<Semestre> semestres = new ArrayList<>();

    public Programa(String codigo, String nombre, String jornada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.jornada = jornada;
    }
    //==============================
    //Metodos GET
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getJornada() {
        return jornada;
    }

    public ArrayList<Semestre> getSemestres() {
        return semestres;
    }
    
    //==============================

    //==============================
    //Metodo Buscar
    
    public Asignatura buscar(String codigo, byte semestreNumero) throws Exception{
        
        for(Semestre sem: this.semestres){
            if(sem.getNumero()==semestreNumero){
                return sem.buscar(codigo);
            }
        }
        
        throw new Exception("Semestre Invalido");
    }
    
    //==============================

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Programa other = (Programa) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    
    
}
