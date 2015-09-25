
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
    private EstadoCurso estado;

    public Curso(byte grupo,Cupo cupo, Docente docente, Asignatura asignatura) {
        this.grupo = grupo;
        this.totalCupos = cupo.getCantidad(); 
        this.docente = docente;
        this.asignatura = asignatura;
        this.cupos.add(cupo);
        this.estado = EstadoCurso.ACTIVO;
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
      //Metodos Set
    public void setGrupo(byte grupo) {
        this.grupo = grupo;
    }

    public void setTotalCupos(int totalCupos) {
        this.totalCupos = totalCupos;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    public void setCupos(ArrayList<Cupo> cupos) {
        this.cupos = cupos;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    
    
    //==============================
  
    //============================
    //Metodos Add
    public void add(Cupo cupo){
        this.cupos.add(cupo);
        this.totalCupos += cupo.getCantidad();
    }
    
    //============================
    //==============================
    //Metodos Modificar
    public void Modificar(int IndexCupo,Cupo cupo){
        
        this.cupos.add(IndexCupo, cupo);
        
    }
    
    public void Modificar (int IndexHorario, Horario horario){
        this.horarios.add(IndexHorario, horario);
    }
    //==============================
    
    //==============================
    //Metodos Buscar

     public Cupo buscar(Cupo cupo) throws ObjectNotFoundException{
         int index=0;
         if((index = this.cupos.indexOf(cupo))!=-1){
             return this.cupos.get(index);
         }
         
         throw new ObjectNotFoundException("No se encuentra el Cupo");
     }
    
     public Cupo buscar(String codigoPrograma) throws ObjectNotFoundException{
         for(Cupo cup: this.cupos){
             if(cup.getPrograma().getCodigo().equals(codigoPrograma)){
                 return cup;
             }
         }
         throw new ObjectNotFoundException("No se encuentra el Cupo");
     }
     
     
     public Horario buscar(Horario horario) throws ObjectNotFoundException{
         int index=0;
         if((index = this.horarios.indexOf(horario))!=-1){
             return this.horarios.get(index);
         }
         throw new ObjectNotFoundException("Horario no encontrado");                     
     }
     
    
            
     
    //==============================
    
  
  

    
    
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
