/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matricula.UI;

import Matricula.logic.Docente;
import Matricula.logic.Universidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Polker
 */
public class DocentesAvaible extends javax.swing.JFrame {

    /**
     * Creates new form CursosEstudiante
     */
    private Universidad universidad = null;
    private ProgramarCurso proCurso;

    public DocentesAvaible(Universidad universidad, ProgramarCurso pro) {
        this.universidad = universidad;
        this.proCurso = pro;
        initComponents();
        this.ButtonSelected.addActionListener(new ListenerSelected());
        this.TableTeacherAvaible.setModel(new AbstractTableModel() {

            private String[] nombres = {"Identificacion", "Nombre", "Apellido", "Profession"};
            private List<Docente> docentes = universidad.getDocentes();

            @Override
            public int getRowCount() {
                if (docentes.isEmpty()) {
                    return 0;
                }
                return docentes.size();
            }

            @Override
            public int getColumnCount() {
                return nombres.length;
            }

            @Override
            public String getColumnName(int column) {
                return nombres[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Docente teacher = docentes.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return teacher.getIdentificacion();
                    case 1:
                        return teacher.getNombre();
                    case 2:
                        return teacher.getApellido();
                    case 3:
                        return teacher.getProfesion();
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
        TableTeacherAvaible = new javax.swing.JTable();
        ButtonSelected = new javax.swing.JButton();

        TableTeacherAvaible.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableTeacherAvaible);

        ButtonSelected.setText("Seleccionar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonSelected)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonSelected)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSelected;
    private javax.swing.JTable TableTeacherAvaible;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
public class ListenerSelected implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Docente maestro = universidad.getDocentes().get(TableTeacherAvaible.getSelectedRow());
            proCurso.LoadTeacher(maestro);
            TableTeacherAvaible.clearSelection();
            setVisible(false);

        }

    }

}
