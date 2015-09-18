/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.util.Objects;

/**
 *
 * @author atenea
 */
public class Deuda {
    
    private Periodo periodo;

    public Deuda(Periodo periodo) {
        this.periodo = periodo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    

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
