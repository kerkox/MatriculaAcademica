package main;

import Matricula.UI.Principal;
import Matricula.logic.Periodo;
import Matricula.logic.*;
import Matricula.logic.enumclass.Jornada;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.derby.drda.NetworkServerControl;

/**
 *
 * @author Polker
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        boolean initServer; 
        splashInit();           // initialize splash overlay drawing parameters
        appInit();              // simulate what an application would do 
//        Connection conn = null;
        // before starting
        if (mySplash != null) // check if we really had a spash screen
        {
            mySplash.close();   // if so we're now done with it
        }
//         begin with the interactive portion of the program
        try {

            //+++++++++++++++++++++++++++++++++++++++++++++
            //=============================================
            //Codigo de conexion a la BD
            try {
            NetworkServerControl derbyServer = new NetworkServerControl();
            derbyServer.start(null);
            initServer = true;
//            GreenUtil.LOGGER.log(Level.INFO, "javadb server initialized");
        } catch (Exception ex) {
            initServer = false;
//            GreenUtil.LOGGER.log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, GreenUtil.getLocalizedMessage("database.server.init.fail"));
            JOptionPane.showMessageDialog(null, "database.server.init.fail");
            return;
        }

        /**
         * Verificación de la existencia de la base de datos
         */
        File file = new File("Universidad");
        if (!file.exists()) {
            try {
                /**
                 * En caso de no existir la base de datos, se forza la creación
                 * de la misma
                 */
//                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                Connection conn = DriverManager.getConnection("jdbc:derby:Universidad;create=true;user=root;password=toor");
            } catch (ClassNotFoundException | SQLException ex) {
//                GreenUtil.LOGGER.log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
           
            //=============================================
            //+++++++++++++++++++++++++++++++++++++++++++++
            Periodo periodo = new Periodo("Agosto", "Diciembre", 2015);
            Universidad u = new Universidad("800", "Univalle", "Carbonera");
            System.out.println("Va a crear el periodo actual");
            if(u.setPeriodoActual(periodo)){
                System.out.println("Periodo ya creado se usara el que ya esta");
            }
           
              //Programas
            Programa[] programs = {
                new Programa("2711", "Tecnologia de Sistemas", Jornada.DIURNA),
                new Programa("3843", "Ingenieria de Sistemas", Jornada.DIURNA),
                new Programa("3841", "Contaduria Pública", Jornada.DIURNA)
            };
            if (u.getProgramas().isEmpty()) {
                //Registro de Programas
                for (Programa x : programs) {
                    u.registrar(x);
                }
            }
            
//*********************************
            //Estudiantes            
            Estudiante[] students = {
                new Estudiante("123", 12345, "Pol", "Cortes", "1234", programs[0]),
                new Estudiante("1234", 123456789, "Jeniffer", "Rosales", "1234", programs[2])};
            if (u.getEstudiantes().isEmpty()) {
                System.out.println("la lista de estudiantes en la BD es vacia");
                //Registro de Estudiantes
                for (Estudiante x : students) {
                    u.registrar(x);
                }
            }
//*********************************            
            //Docentes
            Docente[] teachers = {
                new Docente("Ingeniero de Sistemas", 123, "Antonio", "Velez", "1234"),
                new Docente("Matematico", 54321, "Jaime", "Florez", "1234"),
                new Docente("Ingeniero Electronico", 4321, "Duvan", "Garcia", "1234"),
                new Docente("Ingeniera de Sistemas", 654321, "Natalia", "Henao", "1234")

            };
            if (u.getDocentes().isEmpty()) {
                //Registro de Docentes
                for (Docente x : teachers) {
                    u.registrar(x);
                }
            }
//*********************************

            //Asignaturas
            Asignatura[] subjects = {
                new Asignatura("12345", "Interactivas", (byte) 4, (byte) 4),
                new Asignatura("456", "Calculo 2", (byte) 4, (byte) 5),
                new Asignatura("789", "Arquitectura 2", (byte) 3, (byte) 4),
                new Asignatura("987", "Algebra Lineal", (byte) 4, (byte) 4),
                new Asignatura("123", "Matematicas Discretas", (byte) 3, (byte) 4),
                new Asignatura("123", "Matematicas financieras", (byte) 3, (byte) 4)
                
            };
            if (u.getAsignaturas().isEmpty()) {
                //Registro de Asignaturas
                for (Asignatura x : subjects) {
                    u.registrar(x);
                }
            }
//*********************************

          
//*********************************

            //Cupos
            Cupo[] cupos = {
                new Cupo(55, programs[0]),
                new Cupo(50, programs[1]),
                new Cupo(60, programs[2]),
                new Cupo(55, programs[2])
            };
//*********************************

            //Cursos
            Curso[] cursos = {
                new Curso((byte) 50, cupos[0], teachers[0], subjects[0]),
                new Curso((byte) 51, cupos[0], teachers[1], subjects[1]),
                new Curso((byte) 50, cupos[0], teachers[2], subjects[2]),
                new Curso((byte) 52, cupos[0], teachers[3], subjects[4]),
                new Curso((byte) 50, cupos[0], teachers[1], subjects[3])
            };
//################################################################
            if (u.getPeridoActual().getCursos().isEmpty()) {
                System.out.println("Aqui no hay Cursos todavia");

                //Registro de Cursos
                for (Curso x : cursos) {
                    u.registrar(x);
                }
                System.out.println("Termino de hacer los registros");
            }

            if (u.getPeridoActual() == null) {
                System.out.println("Entro aqui porque no tiene perido actual");

            }

//*********************************
            System.out.println("Debe de hacer la conexion a la bd");
            //################################################################
//            new PantallaCargandoMain();
            new Principal(u).setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Prepare the global variables for the other splash functions
     */
//    -splash:src/Resources/univalle400x558.jpg
    static Rectangle2D.Double splashTextArea;
    static Rectangle2D.Double splashProgressArea;
    static Graphics2D splashGraphics;
    static Font font;
    static SplashScreen mySplash;

    private static void splashInit() {

        mySplash = SplashScreen.getSplashScreen();
        if (mySplash != null) {   // if there are any problems displaying the splash this will be null
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;
            // stake out some area for our status information
            splashTextArea = new Rectangle2D.Double(15., height * 0.88, width * .45, 32.);
            splashProgressArea = new Rectangle2D.Double(width * .55, height * .92, width * .4, 12);

            // create the Graphics environment for drawing status info
            splashGraphics = mySplash.createGraphics();
            font = new Font("Dialog", Font.PLAIN, 18);
            splashGraphics.setFont(font);

            // initialize the status info
            splashText("Starting");
            splashProgress(0);
        }
    }

    /**
     * Display text in status area of Splash. Note: no validation it will fit.
     *
     * @param str - text to be displayed
     */
    public static void splashText(String str) {
        if (mySplash != null && mySplash.isVisible()) {   // important to check here so no other methods need to know if there
            // really is a Splash being displayed

            // erase the last status text
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.fill(splashTextArea);

            // draw the text
            splashGraphics.setPaint(Color.BLACK);
            splashGraphics.drawString(str, (int) (splashTextArea.getX() + 10), (int) (splashTextArea.getY() + 15));

            // make sure it's displayed
            mySplash.update();
        }
    }

    /**
     * Display a (very) basic progress bar
     *
     * @param pct how much of the progress bar to display 0-100
     */
    public static void splashProgress(int pct) {
        if (mySplash != null && mySplash.isVisible()) {

            // Note: 3 colors are used here to demonstrate steps
            // erase the old one
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.fill(splashProgressArea);

            // draw an outline
            splashGraphics.setPaint(Color.BLUE);
            splashGraphics.draw(splashProgressArea);

            // Calculate the width corresponding to the correct percentage
            int x = (int) splashProgressArea.getMinX();
            int y = (int) splashProgressArea.getMinY();
            int wid = (int) splashProgressArea.getWidth();
            int hgt = (int) splashProgressArea.getHeight();

            int doneWidth = Math.round(pct * wid / 100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, wid - 1));  // limit 0-width

            // fill the done part one pixel smaller than the outline
            splashGraphics.setPaint(Color.BLUE);
            splashGraphics.fillRect(x, y + 1, doneWidth, hgt - 1);

            // make sure it's displayed
            mySplash.update();
        }
    }

    /**
     * just a stub to simulate a long initialization task that updates the text
     * and progress parts of the status in the Splash
     */
    private static void appInit() {
        for (int i = 1; i <= 10; i++) {
            int pctDone = i * 10;
            splashText("Cargando... " + i * 10 + "%");
            splashProgress(pctDone);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                // ignore it
            }
        }
    }

}
