/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.UI;

import Matricula.logic.Asignatura;
import Matricula.logic.Cupo;
import Matricula.logic.Curso;
import Matricula.logic.Docente;
import Matricula.logic.Exceptions.ObjectNotFoundException;
import Matricula.logic.Programa;
import Matricula.logic.Universidad;
import Matricula.logic.enumclass.EstadoCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author atenea
 */
public class ProgramarCurso extends javax.swing.JFrame {

    /**
     * Creates new form ProgramarCurso
     */
    private Docente docenteLogueado;
    private Universidad u;
    private Docente docente;
    private Curso curso;
    private Asignatura asignatura;
    private ProgramarCurso proCurso = this;
    private Principal main;
    private Cupo cupo;
    private HorariosCurso horariosUI = null;
    private boolean save = false;
    
    public ProgramarCurso(Docente docente, Universidad u, Principal main) {
        this.docenteLogueado = docente;
        this.main = main;
        this.u = u;
        initComponents();
        //***************************************   
        ListenerAddTime AddTime = new ListenerAddTime();
        ButtonSetTime.addActionListener(AddTime);
        //***************************************   
        ListenerAddCupo AddCupo = new ListenerAddCupo();
        ButtonAddCupo.addActionListener(AddCupo);
        //***************************************   
        SeleccionarDocente sd = new SeleccionarDocente();
        TeacherSelected.addActionListener(sd);
        //***************************************
        ListenerFinished lf = new ListenerFinished();
        ButtonFinished.addActionListener(lf);
        //***************************************   
        SeleccionarAsignatura sa = new SeleccionarAsignatura();
        SubjectSearch.addActionListener(sa);
        //***************************************   
        BuscarDocente BuscarDoc = new BuscarDocente();
        TeacherID.addActionListener(BuscarDoc);
        ButtonSearchTeacher.addActionListener(BuscarDoc);
        //***************************************   
        SearchSubject sc = new SearchSubject();
        SubjectCode.addActionListener(sc);
        //***************************************   
        ListenerSpinnerValue lsv = new ListenerSpinnerValue();
        SubjectGroup.addChangeListener(lsv);
        SubjectGroup.setValue(50);//valor por defecto
        CuposNumber.addChangeListener(lsv);
        //***************************************   
        Guardar guardar = new Guardar();
        Save.addActionListener(guardar);
        //***************************************   
        ListenerNewCourse lnc = new ListenerNewCourse();
        NewCourse.addActionListener(lnc);
        //***************************************   
        TableCupos.setModel(new AbstractTableModel() {
            
            String[] names = {"Programa", "Cupos"};
            
            @Override
            public int getRowCount() {
                if (curso == null) {
                    return 0;
                }
                return curso.getCupos().size();
            }
            
            @Override
            public String getColumnName(int columnIndex) {
                return names[columnIndex];
            }
            
            @Override
            public int getColumnCount() {
                return names.length;
            }
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Cupo cupo = curso.getCupos().get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return cupo.getPrograma().toString();
                    case 1:
                        return cupo.getCantidad();
                }
                return "";
            }
        });
        
        for (Programa pro : u.getProgramas()) {
            CupoList.addItem(pro);
        }
        
    }
    
    public void ActivateProgramCourse(boolean yn) {
        ButtonSetTime.setEnabled(yn);
        CupoList.setEnabled(yn);
        CuposNumber.setEnabled(yn);
        ButtonAddCupo.setEnabled(yn);
        TableCupos.updateUI();
        
    }
    
    public void LoadSubject(Asignatura subject) {
        this.curso = new Curso();
        this.asignatura = subject;
        SubjectCode.setText(asignatura.getCodigo());
        SubjectCredits.setText(asignatura.getCreditos() + "");
        SubjectIntensity.setText(asignatura.getIntensidad() + "");
        SubjectName.setText(asignatura.getNombre());
        curso.setAsignatura(asignatura);
        if (docente != null) {
            ActivateProgramCourse(true);
        }
        
    }
    
    public void LoadTeacher(Docente profesor) {
        if (curso == null) {
            curso = new Curso();
        }
        this.docente = profesor;
        TeacherID.setText(profesor.getIdentificacion() + "");
        TeacherName.setText(profesor.getFullName());
        TeacherEducation.setText(profesor.getProfesion());
        curso.setDocente(docente);
        if (asignatura != null) {
            ActivateProgramCourse(true);
        }
        
    }

    /**
     * Reinicio de toda la interfaz y las variables
     */
    public void clear() {
        this.docente = null;
        this.asignatura = null;
        this.curso = null;
        this.cupo = null;
        this.save = false;
        ActivateProgramCourse(save);
        NewCourse.setEnabled(save);
        
        this.TeacherEducation.setText("");
        this.TeacherID.setText("");
        this.TeacherName.setText("");
        
        this.SubjectCode.setText("");
        this.SubjectCredits.setText("");
        this.SubjectIntensity.setText("");
        this.SubjectName.setText("");
        
        this.TableCupos.clearSelection();
        this.TableCupos.updateUI();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SubjectSearch = new javax.swing.JButton();
        SubjectName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        SubjectCredits = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        SubjectIntensity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SubjectCode = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TeacherName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TeacherEducation = new javax.swing.JTextField();
        TeacherID = new javax.swing.JFormattedTextField();
        ButtonSearchTeacher = new javax.swing.JButton();
        TeacherSelected = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        CupoList = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        ButtonAddCupo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCupos = new javax.swing.JTable();
        CuposNumber = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        CuposTotal = new javax.swing.JTextField();
        NewCourse = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        ButtonFinished = new javax.swing.JButton();
        ButtonSetTime = new javax.swing.JButton();
        SubjectGroup = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Asignatura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jLabel1.setText("Código:");

        SubjectSearch.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        SubjectSearch.setText("...");

        SubjectName.setEditable(false);

        jLabel2.setText("Nombre:");

        SubjectCredits.setEditable(false);

        jLabel3.setText("Creditos:");

        SubjectIntensity.setEditable(false);

        jLabel4.setText("intensidad Horaria:");

        SubjectCode.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SubjectIntensity, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SubjectSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SubjectCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 57, Short.MAX_VALUE))
                            .addComponent(SubjectName))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(SubjectSearch)
                    .addComponent(jLabel3)
                    .addComponent(SubjectCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SubjectIntensity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Grupo:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Docente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jLabel6.setText("Identificación:");

        jLabel7.setText("Nombre:");

        TeacherName.setEditable(false);

        jLabel8.setText("Formación:");

        TeacherEducation.setEditable(false);

        TeacherID.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        ButtonSearchTeacher.setText("Buscar");

        TeacherSelected.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        TeacherSelected.setText("...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TeacherName)
                    .addComponent(TeacherEducation)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TeacherID, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TeacherSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonSearchTeacher)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TeacherID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSearchTeacher)
                    .addComponent(TeacherSelected))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TeacherEducation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Cupos por Programa Académico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jLabel9.setText("Programa Académico");

        CupoList.setEnabled(false);

        jLabel10.setText("Cupos:");

        ButtonAddCupo.setText("Agregar");
        ButtonAddCupo.setEnabled(false);

        TableCupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TableCupos);

        CuposNumber.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CupoList, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(CuposNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonAddCupo)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CupoList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonAddCupo)
                    .addComponent(CuposNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel11.setText("Total de Cupos: ");

        CuposTotal.setEditable(false);

        NewCourse.setText("Programar Nuevo Curso");
        NewCourse.setEnabled(false);

        Save.setText("Guardar");

        ButtonFinished.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ButtonFinished.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/boton-regresar50x50.png"))); // NOI18N
        ButtonFinished.setText("Finalizar");

        ButtonSetTime.setText("Asignar Horarios");
        ButtonSetTime.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 40, Short.MAX_VALUE)
                                .addComponent(ButtonSetTime))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(SubjectGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CuposTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ButtonFinished, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SubjectGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(ButtonSetTime)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(CuposTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonFinished, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewCourse)
                    .addComponent(Save))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new ListenerFinished().actionPerformed(null);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAddCupo;
    private javax.swing.JButton ButtonFinished;
    private javax.swing.JButton ButtonSearchTeacher;
    private javax.swing.JButton ButtonSetTime;
    private javax.swing.JComboBox CupoList;
    private javax.swing.JSpinner CuposNumber;
    private javax.swing.JTextField CuposTotal;
    private javax.swing.JButton NewCourse;
    private javax.swing.JButton Save;
    private javax.swing.JFormattedTextField SubjectCode;
    private javax.swing.JTextField SubjectCredits;
    private javax.swing.JSpinner SubjectGroup;
    private javax.swing.JTextField SubjectIntensity;
    private javax.swing.JTextField SubjectName;
    private javax.swing.JButton SubjectSearch;
    private javax.swing.JTable TableCupos;
    private javax.swing.JTextField TeacherEducation;
    private javax.swing.JFormattedTextField TeacherID;
    private javax.swing.JTextField TeacherName;
    private javax.swing.JButton TeacherSelected;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
public class BuscarDocente implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                docente = u.buscarDocente(Long.parseLong(TeacherID.getText()));
                TeacherEducation.setText(docente.getProfesion());
                TeacherName.setText(docente.getFullName());
                if (curso != null) {
                    ActivateProgramCourse(true);
                }
            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
    }
    
    public class SearchSubject implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                asignatura = u.BuscarAsignatura(SubjectCode.getText().trim());
                SubjectCredits.setText(asignatura.getCreditos() + "");
                SubjectIntensity.setText(asignatura.getIntensidad() + "");
                SubjectName.setText(asignatura.getNombre());
                if (docente != null) {
                    ActivateProgramCourse(true);
                }
            } catch (ObjectNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (NumberFormatException ex) {
                if (SubjectCode.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "El campo Codigo no puede estar vacio");
                }
            }
        }
        
    }
    
    public class SeleccionarAsignatura implements ActionListener {
        
        CursosProgramados cursoPro = null;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (cursoPro == null) {
                cursoPro = new CursosProgramados(u, proCurso);
            }
            cursoPro.setVisible(true);
        }
        
    }
    
    public class ListenerFinished implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (save) {
                this.exit();
            } else {
                int op = JOptionPane.showConfirmDialog(null, "desea Salir sin Guardar", "Guardar?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (op == 0) {
                    this.exit();
                }
            }
            
        }
        
        public void exit() {
            docenteLogueado = null;
            main.setVisible(true);
            setVisible(false);
        }
        
    }
    
    public class SeleccionarDocente implements ActionListener {
        
        DocentesAvaible DocAvaible = null;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (DocAvaible == null) {
                DocAvaible = new DocentesAvaible(u, proCurso);
            }
            DocAvaible.setVisible(true);
        }
        
    }
    
    public class ListenerAddCupo implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                Programa pro = (Programa) CupoList.getSelectedItem();
                cupo = new Cupo((int) CuposNumber.getValue(), pro);
                curso.add(cupo);
                TableCupos.updateUI();
                cupo = null;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            
        }
        
    }
    
    public class ListenerAddTime implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (horariosUI == null) {
                horariosUI = new HorariosCurso(curso);
            }
            horariosUI.setVisible(true);
        }
        
    }
    
    public class Guardar implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                curso.setGrupo((byte)(int)SubjectGroup.getValue());
                curso.setEstado(EstadoCurso.ACTIVO);
                u.registrar(curso);
                save = true;
                NewCourse.setEnabled(save);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            
        }
        
    }
    
    public class ListenerNewCourse implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            clear();
        }
        
    }
    
    public class ListenerSpinnerValue implements ChangeListener {
        

        @Override
        public void stateChanged(ChangeEvent ce) {
            if ((int) CuposNumber.getValue() < 0) {
                CuposNumber.setValue(0);
            }
            if ((int) SubjectGroup.getValue() < 0) {
                SubjectGroup.setValue(0);
            }
        }
        
    }
    
}
