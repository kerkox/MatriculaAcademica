/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author atenea
 */
@Entity
public class Programa implements Serializable {

    @Id
    private String codigo;
    @Column(nullable = false, length = 80)
    private String nombre;
    @Column(nullable = false, length = 30)
    private String jornada;
    @OneToMany
    private List<Semestre> semestres = new ArrayList<>();

    public Programa() {
    }

    public Programa(String codigo, String nombre, String jornada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.jornada = jornada;
    }

    //==============================
    //Metodos GET

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getJornada() {
        return jornada;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    //==============================
    //Metodos Set
    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }

    public void setCodigo(String codigo) {

        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    //==============================
    //==============================
    //Metodo Buscar

    public Asignatura buscar(String codigo, byte semestreNumero) throws Exception {
        for (Semestre sem : this.semestres) {
            if (sem.getNumero() == semestreNumero) {
                return sem.buscar(codigo);
            }
        }

        throw new Exception("Semestre Invalido");
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
        final Programa other = (Programa) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

}
