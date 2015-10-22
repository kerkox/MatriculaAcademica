/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.UI;

import Matricula.logic.Curso;
import Matricula.logic.Periodo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Polker
 */
public class CursosEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form CursosEstudiante
     */
    private Periodo periodo = null;
    private MatriculaUI matri;
    public CursosEstudiante(Periodo periodo, MatriculaUI matri) {
        
        initComponents();
        this.matri = matri;
        this.periodo = periodo;
        this.ButtonSelected.addActionListener(new ListenerSelected());
        this.TableCursoStudent.setModel(new AbstractTableModel() {

            
            private String[] nombres = {"Codigo Asig.", "Nombre Asignatura", "Grupo", "Docente"};
            
            @Override
            public int getRowCount() {
                if(periodo.getCursos().isEmpty()){
                    return 0;
                }
                return periodo.getCursos().size();
            }

            @Override
            public int getColumnCount() {
                return nombres.length;
            }
            
            @Override
            public String getColumnName(int column){
                return nombres[column];
            }
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Curso curso = periodo.getCursos().get(rowIndex);
                switch(columnIndex){
                    case 0:
                        return curso.getAsignatura().getCodigo();
                    case 1:
                        return curso.getAsignatura().getNombre();
                    case 2:
                        return curso.getGrupo();
                    case 3:
                        return curso.getDocente().getFullName();
                }
                return "";
                
            }
            
            
        });
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
        TableCursoStudent = new javax.swing.JTable();
        ButtonSelected = new javax.swing.JButton();

        TableCursoStudent.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableCursoStudent);

        ButtonSelected.setText("Seleccionar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonSelected)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(ButtonSelected)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSelected;
    private javax.swing.JTable TableCursoStudent;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
public class ListenerSelected implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Curso curso = periodo.getCursos().get(TableCursoStudent.getSelectedRow());
            matri.LoadMatricula(curso);
            setVisible(false);
        }
    
}

}
