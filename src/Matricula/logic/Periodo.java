/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import Matricula.logic.Exceptions.ObjectNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author atenea
 */
@Entity
@Table(name = "PERIODO", uniqueConstraints = @UniqueConstraint(columnNames = {"incia", "year1"}))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p"),
    @NamedQuery(name = "Periodo.findById", query = "SELECT p FROM Periodo p WHERE p.id = :id"),
    @NamedQuery(name = "Periodo.findByActual", query = "SELECT p FROM Periodo p WHERE p.actual = :actual"),
    @NamedQuery(name = "Periodo.findByFin", query = "SELECT p FROM Periodo p WHERE p.fin = :fin"),
    @NamedQuery(name = "Periodo.findByInicia", query = "SELECT p FROM Periodo p WHERE p.inicia = :inicia"),
    @NamedQuery(name = "Periodo.findByYear1", query = "SELECT p FROM Periodo p WHERE p.year1 = :year1")})
public class Periodo implements Serializable {
   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String inicia;
    @Column
    private String fin;
    @Column (nullable = false)
    private int year1;
    @OneToMany
    private List<Curso> cursos = new ArrayList<>();
    @Column (nullable = false)
    private boolean actual;

    public Periodo() {
    }

    public Periodo(String inicia, String fin, int year1) {
        this.inicia = inicia;
        this.fin = fin;
        this.year1 = year1;
        this.actual = true;
    }

    
    
    
    //============================
    //Metodos Get
    
    public boolean isActual() {
        return actual;
    }

    public String getInicia() {
        return inicia;
    }

    public String getFin() {
        return fin;
    }

    public int getYear() {
        return year1;
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

    
    public void setInicia(String inicia) {
        this.inicia = inicia;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public void setYear(int year) {
        this.year1 = year;
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
        if (this.year1 != other.year1) {
            return false;
        }
        return true;
    }

    public Periodo(Long id) {
        this.id = id;
    }

    public Periodo(Long id, boolean actual, int year1) {
        this.id = id;
        this.actual = actual;
        this.year1 = year1;
    }

    

    public int getYear1() {
        return year1;
    }

    public void setYear1(int year1) {
        this.year1 = year1;
    }

    @Override
    public String toString() {
        return   inicia + " - " + fin + " " + year1 ;
    }

    

    

}
