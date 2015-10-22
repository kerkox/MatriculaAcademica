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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author atenea
 */
@Entity
@Table(name = "ESTUDIANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByIdentificacion", query = "SELECT e FROM Estudiante e WHERE e.identificacion = :identificacion"),
    @NamedQuery(name = "Estudiante.findByApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Estudiante.findByCodigo", query = "SELECT e FROM Estudiante e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre")})
public class Estudiante extends Persona {


    @Column(nullable = false)
    private String codigo;
    @OneToMany
    private List<Tabulado> tabulados = new ArrayList<>();
    @OneToMany
    private List<Deuda> deudas = new ArrayList<>();
    @OneToOne
    private Tabulado tabuladoActual;

    public Estudiante() {
    }

    public Estudiante(String codigo, long identificacion, String nombre, String apellido, String password) {
        super(identificacion, nombre, apellido, password);
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
    
    public Tabulado getTabuladoActual(){
        return tabuladoActual;
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
    //Metodos de matricula
    public void Matricular(Curso curso){
        //////*********************************
        this.tabuladoActual.MatricularCurso(curso);
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
