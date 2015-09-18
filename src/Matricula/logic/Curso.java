
package Matricula.logic;

import java.util.ArrayList;

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

    

    //============================
    //Metodos Get
    
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
    
    public Asignatura buscar(String codigo, byte semestreNumero) throws Exception{
        Asignatura asig= null;
        for(Cupo cupo: this.cupos){
            try{
                asig = cupo.getPrograma().buscar(codigo, semestreNumero);
                
            }catch(Exception ex){
                
            }
        }
        if(asig==null){
            throw new Exception("Asignatura no encontrada");
        }
        
        return asig;
        
    }
    
    
    //==============================
    
}
