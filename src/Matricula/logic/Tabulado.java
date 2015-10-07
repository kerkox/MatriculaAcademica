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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TABULADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabulado.findAll", query = "SELECT t FROM Tabulado t"),
    @NamedQuery(name = "Tabulado.findById", query = "SELECT t FROM Tabulado t WHERE t.id = :id")})
public class Tabulado implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Matricula> matriculas = new ArrayList<>();
    @OneToOne
    private Periodo periodo;
    

    public Tabulado() {
    }

    public Tabulado(Periodo perido) {
        this.periodo = perido;
        
    }

    //==============================
    //Metodos Get
    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public Periodo getPerido() {
        return periodo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public Long getId() {
        return id;
    }

    //==============================
    //==============================
    //Metodos Set

    public void setId(Long id) {
        this.id = id;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    //==============================
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
