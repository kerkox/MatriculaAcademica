package main;

import Matricula.UI.LoginStudent;
import Matricula.logic.Periodo;
import Matricula.logic.*;
import Matricula.logic.enumclass.Jornada;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Polker
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            
            Periodo periodo = new Periodo("Agosto", "Diciembre", 2015);
            Universidad u = new Universidad("800", "Univalle", "Carbonera", periodo);

            if(u.getEstudiantes()==null){
            //Estudiantes            
            Estudiante[] students = {
                new Estudiante("123", 12345, "Pol", "Cortes", "1234"),
                new Estudiante("1234", 123456789, "Jeniffer", "Rosales", "1234")};
            
            
            
            //Docentes
            Docente[] teachers = {
                new Docente("Ingeniero de Sistemas", 123, "Antonio", "Velez", "1234"),
                new Docente("Ingeniero Electronico", 54321, "Duvan", "Garcia", "1234")

            };
            
            
            
            //Asignaturas
            Asignatura[] subjects = {
                new Asignatura("12345", "Interactivas", (byte) 4, (byte) 4),
                new Asignatura("456", "Calculo 2", (byte) 4, (byte) 5)
            };
            
            
            //Programas
            Programa[] programs = {
                new Programa("2711", "Tecnologia de Sistemas", Jornada.DIURNA),
                new Programa("3843", "Ingenieria de Sistemas", Jornada.DIURNA),
                new Programa("3841", "Contaduria Pública", Jornada.DIURNA)
            };
            
            
            //Cupos
            Cupo[] cupos = {
                new Cupo(55, programs[0]),
                new Cupo(50, programs[1]),
                new Cupo(60, programs[2])
            };

            //Registro de Estudiantes
            for (Estudiante x : students) {
                u.registrar(x);
            }
            //Registro de Docentes
            for (Docente x : teachers) {
                u.registrar(x);
            }
            //Registro de Asignaturas
            for (Asignatura x : subjects) {
                u.registrar(x);
            }
            //Registro de Programas
            for (Programa x : programs) {
                u.registrar(x);
            }
            }
            System.out.println("Debe de hacer la conexion a la bd");
            new LoginStudent(u).setVisible(true);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
