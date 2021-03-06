package Matricula.logic;

import Matricula.logic.Exceptions.DateBeforeException;
import Matricula.logic.Exceptions.ObjectNotFoundException;
import Matricula.logic.enumclass.Estado;
import Matricula.logic.enumclass.Mes;
import Matricula.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public void CrearPeriodo(Mes incia, Mes finaliza, int year) throws DateBeforeException, Exception {

        Periodo actual = getPeridoActual();
        Periodo periodo = new Periodo(incia, finaliza, year);
        switch (PeriodoBefore(periodo, actual)) {
            case 0:
                throw new DateBeforeException("ERROR: periodo ya creado (Actual)");
            case 1:
                throw new DateBeforeException("No se puede crear un periodo anterior: ");
            case 2:
                throw new DateBeforeException("No se puede crear un periodo de un año anterior: " + periodo.getYear());
        }

        getPeridoActual().setActual(false);
        this.periodoJpa.edit(getPeridoActual());
        this.periodoJpa.create(periodo);
    }

    /**
     *
     * @param inicial Periodo inicial
     * @param Final Periodo Final
     * @return 1 si el periodo inicial esta antes del final 0 si es el mismo -1
     * en caso del inicial estar despues del final 2 en caso de ser el inicial
     * de un año anterior al final
     */
    public int PeriodoBefore(Periodo inicial, Periodo Final) {
        if (inicial.getYear() < Final.getYear()) {
            return 2;
        }
        if (inicial.getYear() == Final.getYear()) {
            if ((inicial.getInicia().equals(Mes.Febrero)) && (Final.getInicia().equals(Mes.Agosto))) {
                return 1;
            }
            if (((inicial.getInicia().equals(Mes.Febrero)) && (Final.getInicia().equals(Mes.Febrero)))
                    || (((inicial.getInicia().equals(Mes.Agosto)) && (Final.getInicia().equals(Mes.Agosto))))) {
                return 0;
            }
        }
        return -1;

    }

    public void CrearPeriodo(Periodo periodo) throws DateBeforeException, Exception {
        Periodo actual = getPeridoActual();

        switch (PeriodoBefore(periodo, actual)) {
            case 0:
                throw new DateBeforeException("ERROR: periodo ya creado (Actual)");
            case 1:
                throw new DateBeforeException("No se puede crear un periodo anterior: ");
            case 2:
                throw new DateBeforeException("No se puede crear un periodo de un año anterior: " + periodo.getYear());
        }
        
        actual.setActual(false);
        this.periodoJpa.edit(actual);
        this.periodoJpa.create(periodo);
        
    }
    
    public void ActulizarPeriodoEstudiantes() throws Exception{
        for(Estudiante est: this.estudianteJpa.findEstudianteEntities()){
//            est.actualizarTabulado(tabuladoJpa);
            Tabulado tabuActual = est.getTabuladoActual();
            tabuActual.setActual(false);
            this.tabuladoJpa.edit(tabuActual);
            this.estudianteJpa.edit(est);
        }
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

    public void registrarIncial(Curso curso) throws Exception {

        cursoJpa.create(curso);
        Periodo periodo = getPeridoActual();
        periodo.add(curso);
        periodoJpa.edit(periodo);

    }

    public void registrar(Curso curso) throws Exception {

        boolean create = true;
        if (curso == null) {
            throw new Exception("No se ha creado el Curso");
        }
        if (curso.getHorarios().isEmpty()) {
            throw new Exception("No se ha registrado Un horario al curso");
        }
        if (curso.getCupos().isEmpty()) {
            throw new Exception("No se ha registrado Un Cupo al curso");
        }
        if (curso.getDocente() == null) {
            throw new Exception("Docente no asignado");
        }
        if (curso.getAsignatura() == null) {
            throw new Exception("Asignatura no asignada");
        }
        List<Curso> cursos = cursoJpa.findCursoEntities();

        if (cursos.contains(curso)) {
            if (cursos.get(cursos.indexOf(curso)).getEstado() == Estado.CANCELADO) {
                Curso course = cursoJpa.findCursoEntities().get(cursos.indexOf(curso));
                course.setEstado(Estado.ACTIVO);
                cursoJpa.edit(course);
                Periodo periodo = getPeridoActual();
                periodo.editCurso(curso);
                periodoJpa.edit(periodo);
                create = false;

            } else {
                throw new Exception("ERROR CURSO YA REGISTRADO");
            }

        }

        if (create) {
            cursoJpa.create(curso);
            Periodo periodo = getPeridoActual();
            periodo.add(curso);
            periodoJpa.edit(periodo);
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

    public Asignatura BuscarAsignatura(String code) throws ObjectNotFoundException {
        for (Asignatura subject : this.asignaturas) {
            if (subject.getCodigo().equals(code)) {
                return subject;
            }

        }
        throw new ObjectNotFoundException("Asignatura con codigo: " + code + " no encontrada");
    }

    //////*********************************
    public void MatricularCurso(Estudiante estu, Curso curso) throws Exception {
        estu.Matricular(curso, getPeridoActual(), cursoJpa, matricualJpa);
        estudianteJpa.edit(estu);
        //////*********************************
    }

    public void CancelarCurso(Estudiante estu, Curso curso) throws Exception {
        estu.Cancelar(curso, cursoJpa, matricualJpa);

//        cursoJpa.edit(curso);
        List<Matricula> matris = estu.getTabuladoActual().getMatriculas();
        matricualJpa.edit(matris.get(matris.indexOf(new Matricula(new Date(), curso))));

        tabuladoJpa.edit(estu.getTabuladoActual());
        estudianteJpa.edit(estu);

    }

    public void CancelarCursoPeriodo(Curso curso) throws Exception {
        getPeridoActual().CancelarCurso(curso);
        periodoJpa.edit(getPeridoActual());
    }

    public void CancelarCursoPeriodo(int index) throws Exception {
        getPeridoActual().CancelarCurso(index, cursoJpa);
        periodoJpa.edit(getPeridoActual());
    }

    public Curso BuscarCurso(String codeSubject, byte group) throws ObjectNotFoundException {
        Curso course = cursoJpa.findCurso(group, codeSubject);
        if (course == null) {
            throw new ObjectNotFoundException("No se encuentra el Curso: grupo: " + group + " asignatura codigo: " + codeSubject);
        }
        return course;
    }

    public boolean estudiantesMatriculados(Curso curso) {
        List<Estudiante> estudiantes = this.estudianteJpa.findEstudianteEntities();
        for (Estudiante estu : estudiantes) {
            if (estu.getTabuladoActual() == null) {
                continue;
            }
            for (Matricula matri : estu.getTabuladoActual().getMatriculas()) {
                if (matri.getCurso().equals(curso)) {
                    if (matri.getEstado() == Estado.ACTIVO) {
                        return true;
                    }

                }
            }

        }
        return false;

    }

}
