/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author atenea
 */
public class Tabulado {
 
    private ArrayList<Matricula> matriculas= new ArrayList<>();
    private Periodo periodo;

    public Tabulado(Periodo perido) {
        this.periodo = perido;
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    public Periodo getPerido() {
        return periodo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tabulado other = (Tabulado) obj;
        if (!Objects.equals(this.matriculas, other.matriculas)) {
            return false;
        }
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
