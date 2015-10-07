/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author atenea
 */
@Entity
public class Estudiante extends Persona {


    @Column(nullable = false, length = 15)
    private String codigo;
    @OneToMany
    private List<Tabulado> tabulados = new ArrayList<>();
    @OneToMany
    private List<Deuda> deudas = new ArrayList<>();
    @OneToOne
    private Tabulado tabuladoActual;

    public Estudiante() {
    }

    public Estudiante(String codigo, long identificacion, String nombre, String apellido) {
        super(identificacion, nombre, apellido);
        this.codigo = codigo;
    }
    
    //==================================
    //Metodos Get
    public String getCodigo() {
        return codigo;
    }

    public List<Tabulado> getTabulados() {
        return tabulados;
    }

    public List<Deuda> getDeudas() {
        return deudas;
    }
    
    //==================================
    
    //==================================
    //Metodos Add
    
    public void add(Tabulado tabulado){
        if(this.tabuladoActual==null){
            this.tabuladoActual = tabulado;
        }else{
            this.tabulados.add(this.tabuladoActual);
            this.tabuladoActual = tabulado;
        }
        
    }
    
    public void add(Deuda deuda){
        this.deudas.add(deuda);
    }
    
    //==================================
    
    //==================================
    //Metodos Set

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTabulados(List<Tabulado> tabulados) {
        this.tabulados = tabulados;
    }

    public void setDeudas(List<Deuda> deudas) {
        this.deudas = deudas;
    }
    
    
    
    //==================================
  
  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

   
    
    
    
    
}
