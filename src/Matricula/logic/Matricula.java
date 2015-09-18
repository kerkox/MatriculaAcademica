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
public class Matricula {
    
    private Date matriculada;
    private Date cancelada;
    private Curso curso;

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
    
    //============================

    //============================
    //Metodos Set
    public void setCancelada(Date cancelada) {
        this.cancelada = cancelada;
    }
    
    
    
    //============================
}
