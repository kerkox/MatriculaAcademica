/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.logic;

import Matricula.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author atenea
 */
public class Universidad {

    private String nit;
    private String nombre;
    private String direccion;
//    private Periodo peridoActual; // depscreciado en el uso de BD
    private List<Periodo> periodos = new ArrayList<>();
    private List<Programa> programas = new ArrayList<>();
    private List<Asignatura> asignaturas = new ArrayList<>();
    private List<Docente> docentes = new ArrayList<>();
    private List<Estudiante> estudiantes = new ArrayList<>();

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MatriculaAcademicaPU");

    private AsignaturaJpaController asignaturaJpa = new AsignaturaJpaController(emf);
    private CupoJpaController cupoJpa = new CupoJpaController(emf);
    private CursoJpaController cursoJpa = new CursoJpaController(emf);
    private DeudaJpaController deudaJpa = new DeudaJpaController(emf);
    private DocenteJpaController docenteJpa = new DocenteJpaController(emf);
    private EstudianteJpaController estudianteJpa = new EstudianteJpaController(emf);
    private HorarioJpaController horarioJpa = new HorarioJpaController(emf);
    private MatriculaJpaController matricualJpa = new MatriculaJpaController(emf);
    private PeriodoJpaController periodoJpa = new PeriodoJpaController(emf);
    private PersonaJpaController personaJpa = new PersonaJpaController(emf);
    private ProgramaJpaController programaJpa = new ProgramaJpaController(emf);
    private SemestreJpaController semestreJpa = new SemestreJpaController(emf);
    private TabuladoJpaController tabuladoJpa = new TabuladoJpaController(emf);

    public Universidad(String nit, String nombre, String direccion, Periodo periodoActual) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.periodoJpa.create(periodoActual);
    }

    //==============================
    //Metodos Get
    public String getNit() {
        return nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Periodo getPeridoActual() {
        //################################
        //Pendiente Optimizar con BD         
        Periodo actual = null;
        for (Periodo per : periodoJpa.findPeriodoEntities()) {
            if (per.isActual()) {
                actual = per;
                break;
            }
        }
        return actual;
    }

    public List<Periodo> getPeriodos() {
        return periodoJpa.findPeriodoEntities();
    }

    public List<Programa> getProgramas() {
        return programaJpa.findProgramaEntities();
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturaJpa.findAsignaturaEntities();
    }

    public List<Docente> getDocentes() {
        return docenteJpa.findDocenteEntities();
    }

    public List<Estudiante> getEstudiantes() {
        return estudianteJpa.findEstudianteEntities();
    }

    //==============================
    //Mostrar los cursos para una asignatura especifica 
    //En el periodo actual
    /**
     *
     * @param code
     * @return Lista de Cursos
     * @throws Exception Asignatura no Encontrada Recibe un codigo de asignatura
     * y busca los cursos con la asignatura en el periodo Actual
     */
    public List<Curso> programacionAsignatura(String code) throws Exception {
         //################################
        //Pendiente Optimizar con BD   
        return getPeridoActual().buscar(code);
    }

    //==============================
    /**
     *
     * @return Lista de todos cursos
     */
    public List<Curso> TodaLaProgramacion() {
         //################################
        //Pendiente Optimizar con BD   
        return getPeridoActual().getCursos();
    }

    public void regitrarCurso(Curso curso) throws Exception {
          //################################
        //Pendiente Optimizar con BD  
        getPeridoActual().add(curso);
    }

    //==============================
    public void modificarCurso(Curso curso) throws Exception {
        cursoJpa.edit(curso);

//        int index =0;
//        if((index = this.peridoActual.getCursos().indexOf(curso))!=-1){
////            this.peridoActual.getCursos().get(index).
//                    
//        }
    }

    /**
     *
     * @param incia Fecha de incio del periodo
     * @param finaliza Fecha de finalizacion del periodo
     * @param year año del periodo
     * @throws DateBeforeException Se lanza el error cuando se desea crear un
     * periodo y el año es anterior al ultimo periodo registrado
     */
    public void CrearPeriodo(Date incia, Date finaliza, int year) throws DateBeforeException {
          //################################
        //Pendiente Optimizar con BD  
        
        if (year < getPeridoActual().getYear()) {
            throw new DateBeforeException("No se puede crear un periodo de un año anterior: " + year);
        }

        Periodo periodo = new Periodo(incia, finaliza, year);
        getPeridoActual().setActual(false);
        this.periodos.add(getPeridoActual());
        this.periodoJpa.create(periodo);
    }

}
