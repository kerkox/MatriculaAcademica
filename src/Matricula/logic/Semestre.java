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
public class Semestre {
    private byte numero;
    private ArrayList<Asignatura> asignaturas = new ArrayList<>();

    public Semestre(byte numero) {
        this.numero = numero;
    }

    //==============================
    //Metodos Get
    public byte getNumero() {
        return numero;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
    
    //==============================
    
    //==============================
    //Metodos buscar
    
    public Asignatura buscar(String codigo) throws Exception{
        
        for(Asignatura asignature: this.asignaturas){
            if(asignature.getCodigo().equals(codigo)){
                return asignature;
            }
        }
        throw new Exception("No se encuentra la Asignatura con codigo: "+ codigo);
    }
    
    
}
