package Matricula.logic;

import Matricula.logic.Exceptions.DateBeforeException;
import Matricula.logic.Exceptions.ObjectNotFoundException;
import static Matricula.logic.Tabulado_.matriculas;
import Matricula.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

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

    private EntityManagerFactory emf;

    private AsignaturaJpaController asignaturaJpa;
    private CupoJpaController cupoJpa;
    private CursoJpaController cursoJpa;
    private DeudaJpaController deudaJpa;
    private DocenteJpaController docenteJpa;
    private EstudianteJpaController estudianteJpa;
    private HorarioJpaController horarioJpa;
    private MatriculaJpaController matricualJpa;
    private PeriodoJpaController periodoJpa;
    private PersonaJpaController personaJpa;
    private ProgramaJpaController programaJpa;
    private SemestreJpaController semestreJpa;
    private TabuladoJpaController tabuladoJpa;

    public Universidad(String nit, String nombre, String direccion) {

        emf = Persistence.createEntityManagerFactory("MatriculaAcademicaPU");

        asignaturaJpa = new AsignaturaJpaController(emf);
        cupoJpa = new CupoJpaController(emf);
        cursoJpa = new CursoJpaController(emf);
        deudaJpa = new DeudaJpaController(emf);
        docenteJpa = new DocenteJpaController(emf);
        estudianteJpa = new EstudianteJpaController(emf);
        horarioJpa = new HorarioJpaController(emf);
        matricualJpa = new MatriculaJpaController(emf);
        periodoJpa = new PeriodoJpaController(emf);
        personaJpa = new PersonaJpaController(emf);
        programaJpa = new ProgramaJpaController(emf);
        semestreJpa = new SemestreJpaController(emf);
        tabuladoJpa = new TabuladoJpaController(emf);

        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
//        this.periodoJpa.create(periodoActual);
    }

    public boolean setPeriodoActual(Periodo actual) throws Exception {

        return periodoJpa.create(actual);
//       if(periodoJpa.create(actual))  throw new Exception("Ya esta creado el periodo ");

//#################################
        //Como evaluar error de repeticion en la BD
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
        return periodoJpa.findPeriodoActual();
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
        return periodoJpa.findPeriodoActual().buscar(code);
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
        Periodo actual = getPeridoActual();
        actual.add(curso);
        periodoJpa.edit(actual);
        cursoJpa.create(curso);
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
    public void CrearPeriodo(String incia, String finaliza, int year) throws DateBeforeException, Exception {
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

    public void registrar(Estudiante estudiante) {
        try {

            estudianteJpa.create(estudiante);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void registrar(Docente docente) {
        try {
            docenteJpa.create(docente);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void registrar(Asignatura asignatura) {
        try {
            asignaturaJpa.create(asignatura);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void registrar(Programa programa) {
        try {
            programaJpa.create(programa);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void registrar(Curso curso) {
        try {
            cursoJpa.create(curso);
            Periodo periodo = getPeridoActual();
            periodo.add(curso);
            periodoJpa.edit(periodo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }

    public void ActulizarEstudainte(Estudiante estu) throws Exception {
        estudianteJpa.edit(estu);
    }
//Buscar un Curso por codigo de asignatura
//    public Curso buscar(String codeAsignatura){
//        
//    }
    //Metodos de busqueda con BD

    public Estudiante buscarEstudiante(String codigo) throws ObjectNotFoundException {
        Estudiante estu = estudianteJpa.findEstudianteCode(codigo);
        if (estu == null) {
            throw new ObjectNotFoundException("El estudiante con codigo: " + codigo + " No fue encontrado");
        }
        return estu;
    }

    /**
     *
     * @param estu: estudiante para validad deudas
     * @return true, si esta libre de deudas false, en el caso de que tenga
     * alguna deuda
     */
    public boolean ValidarDeudas(Estudiante estu) {
        return estu.getDeudas().isEmpty();
    }

    public Docente buscarDocente(long id) throws ObjectNotFoundException {
        Docente teacher = docenteJpa.findDocente(id);
        if (teacher == null) {
            throw new ObjectNotFoundException("Docente con identifiacion: " + id + " no encontrado");
        }
        return teacher;
    }

    //////*********************************
    public void MatricularCurso(Estudiante estu, Curso curso) throws Exception {
        estu.Matricular(curso, getPeridoActual(), cursoJpa, matricualJpa);
        estudianteJpa.edit(estu);
        //////*********************************
    }
    
    public void CancelarCurso(Estudiante estu, Curso curso) throws Exception {
        estu.Cancelar(curso, cursoJpa, matricualJpa);

        cursoJpa.edit(curso);
        List<Matricula> matris = estu.getTabuladoActual().getMatriculas();
        matricualJpa.edit(matris.get(matris.indexOf(new Matricula(new Date(), curso))));

        tabuladoJpa.edit(estu.getTabuladoActual());
        estudianteJpa.edit(estu);

    }

    public Curso BuscarCurso(String codeSubject, byte group) throws ObjectNotFoundException {
        Curso course = cursoJpa.findCurso(group, codeSubject);
        if (course == null) {
            throw new ObjectNotFoundException("No se encuentra el Curso: grupo: " + group + " asignatura codigo: " + codeSubject);
        }
        return course;
    }

}
