
package Matricula.logic;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author atenea
 */
public class Curso {
    
    private byte grupo;
    private int totalCupos;
    private ArrayList<Horario> horarios = new ArrayList<>();
    private ArrayList<Cupo> cupos = new ArrayList<>();
    private Docente docente;
    private Asignatura asignatura;

    public Curso(byte grupo,Cupo cupo, Docente docente, Asignatura asignatura) {
        this.grupo = grupo;
        this.totalCupos = cupo.getCantidad(); 
        this.docente = docente;
        this.asignatura = asignatura;
        this.cupos.add(cupo);
    }
    
    
    public ArrayList<Cupo> getCupos() {
        return cupos;
    }

    public Docente getDocente() {
        return docente;
    }

    //============================
    //Metodos Get
    public Asignatura getAsignatura() {
        return asignatura;
    }

    public byte getGrupo() {
        return grupo;
    }

    public int getTotalCupos() {
        return totalCupos;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }
    
    //============================
    
    //============================
    //Metodos Set
    public void setTotalCupos(short totalCupos) {
        this.totalCupos = totalCupos;
    }
    
    //============================

    //============================
    //Metodos Add
    public void add(Cupo cupo){
        this.cupos.add(cupo);
        this.totalCupos += cupo.getCantidad();
    }
    
    //============================
    
    //==============================
    //Metodos Buscar
    
    
    
    
    //==============================

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (this.grupo != other.grupo) {
            return false;
        }
        if (!Objects.equals(this.asignatura, other.asignatura)) {
            return false;
        }
        return true;
    }

    

    
    
    
}
