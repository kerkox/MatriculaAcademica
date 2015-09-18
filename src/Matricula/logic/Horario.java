/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.util.Date;

/**
 *
 * @author atenea
 */
public class Horario {
    private Date horaIncio;
    private Date horaFinalizacion;
    private byte dia;

    public Horario(Date horaIncio, Date horaFinalizacion, byte dia) {
        this.horaIncio = horaIncio;
        this.horaFinalizacion = horaFinalizacion;
        this.dia = dia;
    }

    
    //==============================
    //Metodos Get
    public Date getHoraIncio() {
        return horaIncio;
    }

    public Date getHoraFinalizacion() {
        return horaFinalizacion;
    }

    public byte getDia() {
        return dia;
    }
    
    //==============================
    
    
}
