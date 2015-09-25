/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author atenea
 */
public class Periodo {

    private Date inicia;
    private Date fin;
    private int year;
    private ArrayList<Curso> cursos = new ArrayList<>();

    public Periodo(Date inicia, Date fin, int year) {
        this.inicia = inicia;
        this.fin = fin;
        this.year = year;
    }

    //============================
    //Metodos Get
    public Date getInicia() {
        return inicia;
    }

    public Date getFin() {
        return fin;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
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
    //==============================
    //Metodos Buscar
    /**
     *
     * @param codigoAsig
     * @return la lista con los cursos programados de una asignatura si no se
     * encuentra la asignatura con el codigo, devuelve error
     *
     */
    public ArrayList<Curso> buscar(String codigoAsig) throws Exception {
        ArrayList<Curso> cursosProgramados = new ArrayList<>();
        for (Curso curso : this.cursos) {

            if (curso.getAsignatura().equals(codigoAsig)) {
                cursosProgramados.add(curso);
            }

        }
        if (cursosProgramados.isEmpty()) {
            throw new Exception("Asignatura con codigo: " + codigoAsig + " No encontrada");
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
