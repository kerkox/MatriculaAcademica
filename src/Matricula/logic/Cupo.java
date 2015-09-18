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
public class Cupo {

    private int cantidad;
    private int disponibles;
    private Programa programa;

    public Cupo(int cantidad, int disponibles, Programa programa) {
        this.cantidad = cantidad;
        this.disponibles = disponibles;
        this.programa = programa;
    }

    //============================
    //Metodos Get
    public int getCantidad() {
        return cantidad;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public Programa getPrograma() {
        return programa;
    }
    
    //============================
    
    //============================
    //Metodos Set
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    //============================

    

}
