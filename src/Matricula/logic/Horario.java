/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author atenea
 */
public class Horario {
    private Date horaIncio;
    private Date horaFinalizacion;
    private Dia dia;

    public Horario(Date horaIncio, Date horaFinalizacion, Dia dia) {
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

    public Dia getDia() {
        return dia;
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
        final Horario other = (Horario) obj;
        if (!Objects.equals(this.horaIncio, other.horaIncio)) {
            return false;
        }
        if (!Objects.equals(this.horaFinalizacion, other.horaFinalizacion)) {
            return false;
        }
        if (this.dia != other.dia) {
            return false;
        }
        return true;
    }
    
    
    
}
