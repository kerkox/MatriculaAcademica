/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author atenea
 */
@Entity
public class Cupo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int cantidad;
    @Column
    private int disponibles;
    @OneToOne
    private Programa programa;

    public Cupo() {
    }

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

    public long getId() {
        return id;
    }
    
    
    
    //============================
    
    //============================
    //Metodos Set
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    //============================

    public void setId(long id) {
        this.id = id;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    

}
