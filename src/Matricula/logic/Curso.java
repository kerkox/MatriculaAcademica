
package Matricula.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author atenea
 */
@Entity
public class Curso implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private byte grupo;
    @Column
    private int totalCupos;
    @OneToMany
    private List<Horario> horarios = new ArrayList<>();
    @OneToMany
    private List<Cupo> cupos = new ArrayList<>();
    @OneToOne
    private Docente docente;
    @OneToOne
    private Asignatura asignatura;
    @OneToOne
    private EstadoCurso estado;

    public Curso() {
    }
    

    public Curso(byte grupo,Cupo cupo, Docente docente, Asignatura asignatura) {
        this.grupo = grupo;
        this.totalCupos = cupo.getCantidad(); 
        this.docente = docente;
        this.asignatura = asignatura;
        this.cupos.add(cupo);
        this.estado = EstadoCurso.ACTIVO;
    }
    
    
    public List<Cupo> getCupos() {
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

    public List<Horario> getHorarios() {
        return horarios;
    }

    public EstadoCurso getEstado() {
        return estado;
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

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public void setCupos(List<Cupo> cupos) {
        this.cupos = cupos;
    }

    public void setEstado(EstadoCurso estado) {
        this.estado = estado;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
