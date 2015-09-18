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
    
    public void add(Curso curso) {
        this.cursos.add(curso);
    }
    
    //============================

    //==============================
    //Metodos Buscar
    
    public ArrayList<Curso> buscar(String codigoAsig, byte semestreNumero){
        ArrayList<Curso> cursosProgramados = new ArrayList<>();
        for(Curso curso: this.cursos){
            try{
                curso.buscar(codigoAsig, semestreNumero);
                cursosProgramados.add(curso);
            }catch(Exception ex){
                
            }
        }
        
        return cursosProgramados;
        
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
