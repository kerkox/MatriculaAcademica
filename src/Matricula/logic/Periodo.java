/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author atenea
 */
@Entity
public class Periodo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicia;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin;
    @Column
    private int year;
    @OneToMany
    private List<Curso> cursos = new ArrayList<>();
    @Column (nullable = false)
    private boolean actual;

    public Periodo() {
    }

    public Periodo(Date inicia, Date fin, int year) {
        this.inicia = inicia;
        this.fin = fin;
        this.year = year;
        this.actual = true;
    }

    
    
    
    //============================
    //Metodos Get
    
    public boolean isActual() {
        return actual;
    }

    public Date getInicia() {
        return inicia;
    }

    public Date getFin() {
        return fin;
    }

    public int getYear() {
        return year;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public Long getId() {
        return id;
    }

    //============================
    //============================
    //Metodo Agregar
    public void add(Curso curso) throws Exception {
        if (cursos.contains(curso)) {
            throw new Exception("Curso ya registrado");
        }
        this.cursos.add(curso);
    }

    //============================
    //Metodos Set

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    
    public void setInicia(Date inicia) {
        this.inicia = inicia;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    
    public void setId(Long id) {
        this.id = id;
    }
    //==============================
    
    
    //==============================
    //Metodos Buscar
    /**
     *
     * @param codigoAsig
     * @return la lista con los cursos programados de una asignatura si no se
     * encuentra la asignatura con el codigo, devuelve error
     *
     */
    public List<Curso> buscar(String codigoAsig) throws ObjectNotFoundException {
        ArrayList<Curso> cursosProgramados = new ArrayList<>();
        for (Curso curso : this.cursos) {

            if (curso.getAsignatura().equals(codigoAsig)) {
                cursosProgramados.add(curso);
            }

        }
        if (cursosProgramados.isEmpty()) {
            throw new ObjectNotFoundException("Asignatura con codigo: " + codigoAsig + " No encontrada");
        }

        return cursosProgramados;

    }

    public Curso buscar(Curso curso) throws Exception {
        for (Curso curse : this.cursos) {
            if (curse.equals(curso)) {
                return curse;
            }
        }
        throw new Exception("Curso no encontrado: asinatura codigo"
                + curso.getAsignatura().getCodigo() + " Grupo: "
                + curso.getGrupo()); // agregar datos
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
        final Periodo other = (Periodo) obj;
        if (!Objects.equals(this.inicia, other.inicia)) {
            return false;
        }
        if (!Objects.equals(this.fin, other.fin)) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }

    

}
