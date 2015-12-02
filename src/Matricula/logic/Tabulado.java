/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import Matricula.logic.enumclass.EstadoCurso;
import Matricula.persistence.CursoJpaController;
import Matricula.persistence.MatriculaJpaController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
    @NamedQuery(name = "Tabulado.findById", query = "SELECT t FROM Tabulado t WHERE t.id = :id"),
    @NamedQuery(name = "Tabulado.findByActual", query = "SELECT t FROM Tabulado t WHERE t.actual = :actual")})
public class Tabulado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Matricula> matriculas = new ArrayList<>();
    @OneToOne
    private Periodo periodo;
    @Column
    private byte creditos = 0;
    @Column
    private boolean actual;

    public Tabulado() {
    }

    public Tabulado(Periodo perido) {
        this.periodo = perido;
        this.actual = true;

    }
    
    public void ActualizarCreditos(){
        this.creditos=0;
        for(Matricula matri : this.matriculas){
            this.creditos += matri.getCurso().getAsignatura().getCreditos();
        }
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

    public byte getCreditos() {
        return creditos;
    }

    public boolean isActual() {
        return actual;
    }

    //==============================
    //==============================
    //Metodos Set
    public void setActual(boolean Actual) {
        this.actual = Actual;
    }

    public void setCreditos(byte creditos) {
        this.creditos = creditos;
    }

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
    //Matricular cursos
    //////*********************************
    public void MatricularCurso(Curso curso) throws Exception {
        if (matriculas.contains(new Matricula(new Date(), curso))) {
            Matricula matri = matriculas.get(matriculas.indexOf(new Matricula(new Date(), curso)));
            if (matri.getCurso().getEstado() == EstadoCurso.CANCELADO) {
                matri.getCurso().setEstado(EstadoCurso.ACTIVO);
                creditos += matri.getCurso().getAsignatura().getCreditos();

            } else {
                throw new Exception("Curso ya Matriculado");
            }
        } else {
            this.matriculas.add(new Matricula(new Date(), curso));

            creditos += curso.getAsignatura().getCreditos();

        }
    }

    public void MatricularCurso(Curso curso, CursoJpaController CursoJpa, MatriculaJpaController matriculaJpa) throws Exception {
        if (matriculas.contains(new Matricula(new Date(), curso))) {
            Matricula matri = matriculas.get(matriculas.indexOf(new Matricula(new Date(), curso)));
            if (matri.getCurso().getEstado() == EstadoCurso.CANCELADO) {
                matri.getCurso().setEstado(EstadoCurso.ACTIVO);
                CursoJpa.edit(matri.getCurso());
                creditos += matri.getCurso().getAsignatura().getCreditos();
                matriculaJpa.edit(matri);

            } else {
                throw new Exception("Curso ya Matriculado");
            }
        } else {
            this.matriculas.add(new Matricula(new Date(), curso));
            
            creditos += curso.getAsignatura().getCreditos();

        }
    }

    //==============================
    //Cancelar cursos
    //////*********************************
    public void CancelarCurso(Curso curso) {
        Matricula matri = matriculas.get(matriculas.indexOf(new Matricula(new Date(), curso)));
        if (matri.getCurso().getEstado() == EstadoCurso.ACTIVO) {
            matri.getCurso().setEstado(EstadoCurso.CANCELADO);
            matri.setCancelada(new Date());
            creditos -= matri.getCurso().getAsignatura().getCreditos();

        }
    }

    public void CancelarCurso(Curso curso, CursoJpaController CursoJpa, MatriculaJpaController matriculaJpa) throws Exception {
        Matricula matri = matriculas.get(matriculas.indexOf(new Matricula(new Date(), curso)));
        if (matri.getCurso().getEstado() == EstadoCurso.ACTIVO) {
            if((creditos-matri.getCurso().getAsignatura().getCreditos())<6) throw new Exception("ERROR: no se puede cancelar cantidad minima de creditos invalida (6)");
            matri.getCurso().setEstado(EstadoCurso.CANCELADO);
            CursoJpa.edit(matri.getCurso());
            matri.setCancelada(new Date());
            matriculaJpa.edit(matri);
            creditos -= matri.getCurso().getAsignatura().getCreditos();

        }
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
