/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import Matricula.logic.enumclass.Dia;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author atenea
 */
@Entity 
@Table(name = "HORARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findById", query = "SELECT h FROM Horario h WHERE h.id = :id"),
    @NamedQuery(name = "Horario.findByDia", query = "SELECT h FROM Horario h WHERE h.dia = :dia"),
    @NamedQuery(name = "Horario.findByHorafinalizacion", query = "SELECT h FROM Horario h WHERE h.horafinalizacion = :horafinalizacion"),
    @NamedQuery(name = "Horario.findByHoraincio", query = "SELECT h FROM Horario h WHERE h.horaincio = :horaincio")})
public class Horario implements Serializable {
  
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horaIncio;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horaFinalizacion;
    @Column
    private Dia dia;

    public Horario() {
    }
    

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
    
    public Long getId() {
        return id;
    }
    
    //==============================
    //Metodos Set
    
    public void setHoraIncio(Date horaIncio) {
        this.horaIncio = horaIncio;
    }

    public void setHoraFinalizacion(Date horaFinalizacion) {
        this.horaFinalizacion = horaFinalizacion;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }
   
    public void setId(Long id) {
        this.id = id;
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

    public Horario(Long id) {
        this.id = id;
    }
    
}
