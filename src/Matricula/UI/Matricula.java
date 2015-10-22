/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.UI;

import Matricula.logic.Estudiante;
import Matricula.logic.Exceptions.ObjectNotFoundException;
import Matricula.logic.Universidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author atenea
 */
public class Matricula extends javax.swing.JFrame {

    /**
     * Creates new form Matricula
     */
    private Estudiante estu;
    private Universidad u;
    private Principal main;

    public Matricula(Universidad u, Estudiante estu, Principal main) {
        this.main = main;
        this.u = u;
        this.estu = estu;
        initComponents();
        FieldPeriodo.setText(u.getPeridoActual().toString());
        FieldCodeStudent.setText(estu.getCodigo());
        FieldNameStudent.setText(estu.getFullName());

        ButtonSearchCourse.addActionListener(new ListenerCursosProgramados());
        ButtonFinished.addActionListener(new ListenerFinished());
        FieldNumberGroup.addActionListener(new ListenerSearch()); // Busqueda de un Curso por codigo de asignatura
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FieldPeriodo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        FieldCodeStudent = new javax.swing.JTextField();
        FieldNameStudent = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        FieldCodeSubject = new javax.swing.JTextField();
        ButtonSearchCourse = new javax.swing.JButton();
        FieldNameSubject = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        FieldNumberGroup = new javax.swing.JTextField();
        ButtonEnroll = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEnrolls = new javax.swing.JTable();
        ButtonFinished = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Matricula Academica");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Periodo:");

        FieldPeriodo.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Estudiante:");

        FieldCodeStudent.setEditable(false);

        FieldNameStudent.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Asignatura:");

        ButtonSearchCourse.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        ButtonSearchCourse.setText("...");
        ButtonSearchCourse.setMaximumSize(new java.awt.Dimension(45, 20));
        ButtonSearchCourse.setMinimumSize(new java.awt.Dimension(45, 20));
        ButtonSearchCourse.setPreferredSize(new java.awt.Dimension(40, 22));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Grupo:");

        ButtonEnroll.setText("Matricular");

        tableEnrolls.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane2.setViewportView(tableEnrolls);

        ButtonFinished.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ButtonFinished.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/boton-regresar50x50.png"))); // NOI18N
        ButtonFinished.setText("Finalizar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonFinished))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FieldCodeStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FieldNameStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(FieldPeriodo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FieldNumberGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonEnroll)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FieldCodeSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonSearchCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FieldNameSubject)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(ButtonFinished, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(FieldPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(FieldCodeStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FieldNameStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(FieldCodeSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSearchCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FieldNameSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(FieldNumberGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonEnroll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonEnroll;
    private javax.swing.JButton ButtonFinished;
    private javax.swing.JButton ButtonSearchCourse;
    private javax.swing.JTextField FieldCodeStudent;
    private javax.swing.JTextField FieldCodeSubject;
    private javax.swing.JTextField FieldNameStudent;
    private javax.swing.JTextField FieldNameSubject;
    private javax.swing.JTextField FieldNumberGroup;
    private javax.swing.JTextField FieldPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableEnrolls;
    // End of variables declaration//GEN-END:variables
//vamos a hacer una ventana con las materias disponibles para asi evitar el error al buscar
//en la ventana que se muestra los cursos disponibles para el programa del estudiante 

    public class ListenerCursosProgramados implements ActionListener {

        CursosEstudiante courses = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (courses == null) {
                courses = new CursosEstudiante(u.getPeridoActual());
            }
            courses.setVisible(true);
        }
    }
    
    public class ListenerFinished implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            estu = null;
            main.setVisible(true);
            setVisible(false);
        }
        
    }
    
    public class ListenerSearch implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                
                String codeSubject = FieldCodeSubject.getText().trim();
                String grupo = FieldNumberGroup.getText().trim();
                if(codeSubject.equals("")) throw new Exception("El campo del codigo de asignatura no puede ser vacio");
                if(grupo.equals("")) throw new Exception("El campo de grupo no puede ser vacio");
                byte group = Byte.parseByte(grupo);
                    
                
                u.BuscarCurso(codeSubject, group);
            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
    }
            
    

}
