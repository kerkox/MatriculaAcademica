/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author atenea
 */
@Entity
public class Matricula implements Serializable {
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date matriculada;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cancelada;
    @OneToOne
    private Curso curso;

    public Matricula() {
    }
    
    public Matricula(Date matriculada, Curso curso) {
        this.matriculada = matriculada;
        this.curso = curso;
    }

    
    
    //============================
    //Metodos Get
    public Date getMatriculada() {
        return matriculada;
    }

    public Date getCancelada() {
        return cancelada;
    }

    public Curso getCurso() {
        return curso;
    }
    public Long getId() {
        return id;
    }
    
    
    //============================

    //============================
    //Metodos Set
    public void setCancelada(Date cancelada) {
        this.cancelada = cancelada;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setMatriculada(Date matriculada) {
        this.matriculada = matriculada;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    //============================

    public Matricula(Long id) {
        this.id = id;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matricula.logic.Matricula[ id=" + id + " ]";
    }

    
}
