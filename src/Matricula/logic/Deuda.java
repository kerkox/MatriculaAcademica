/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.io.Serializable;
import java.util.Objects;
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
public class Deuda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Periodo periodo;
    //=====================================

    public Deuda() {
    }

    public Deuda(Periodo periodo) {
        this.periodo = periodo;
    }

    //=====================================
    //Metodos Get
    public Periodo getPeriodo() {
        return periodo;
    }

    public Long getId() {
        return id;
    }
    //=====================================
    //=====================================
    //Metodos Set

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //=====================================
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Deuda other = (Deuda) obj;
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        return true;
    }

}
