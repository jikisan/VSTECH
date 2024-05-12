/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jikisan.vstech.DiagnosisForm;

import com.jikisan.vstech.DAO.DbConn;
import com.jikisan.vstech.DAO.NursingManagementDao;
import com.jikisan.vstech.Forms.Dashboard;
import com.jikisan.vstech.Model.DiagnosisModel;
import com.jikisan.vstech.Model.InterventionModel;
import com.jikisan.vstech.Model.NursingManagement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class NurseManagementSummary extends javax.swing.JFrame {

    private ArrayList<String> selectedDiagnosis;
    private ArrayList<String> selectedInterventions;
    private JFrame homepageFrame;
    private NursingManagement nm;

    public NurseManagementSummary () {

    }

    public NurseManagementSummary(ArrayList<String> selectedDiagnosis , ArrayList<String> selectedInterventions, JFrame frame, NursingManagement nm) {
        initComponents();
        this.nm = nm;
        this.homepageFrame = frame;
        this.selectedDiagnosis = selectedDiagnosis;
        this.selectedInterventions = selectedInterventions;
        generateSummary(selectedDiagnosis, selectedInterventions);
    }

    private void generateSummary(ArrayList<String> selectedDiagnosis, ArrayList<String> selectedInterventions) {

        JPanel summaryPanel = createSummaryPanel(selectedDiagnosis, selectedInterventions);
        JScrollPane scrollPane = new JScrollPane(summaryPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBorder(null);

        summaryPannel.setLayout(new BoxLayout(summaryPannel, BoxLayout.Y_AXIS));
        summaryPannel.setOpaque(false);
        summaryPannel.add(scrollPane);
        summaryPannel.revalidate();
        summaryPannel.repaint();
    }

    private JPanel createSummaryPanel(ArrayList<String> selectedDiagnosis, ArrayList<String> selectedInterventions) {
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        panel.setOpaque(false);

        JLabel title1 = new JLabel("Diagnosis: ");
        title1.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(title1);

        for (String diagnosis : selectedDiagnosis) {
            JLabel label = new JLabel();
            label.setText(diagnosis);
            label.setFont(new Font("Arial", Font.PLAIN, 12));
            label.setOpaque(false);
            panel.add(label);
        }

        JLabel title2 = new JLabel("Interventions: ");
        title2.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(title2);

        for (String intervention : selectedInterventions) {
            JLabel label = new JLabel();
            label.setText(intervention);
            label.setFont(new Font("Arial", Font.PLAIN, 12));
            label.setOpaque(false);
            panel.add(label);
        }

        return panel;
    }

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed

        // Create a confirmation dialog with a message
        int response = JOptionPane.showConfirmDialog(
                this, // Parent component
                "Save documentation?", // Message
                "Documenting...", // Title
                JOptionPane.YES_OPTION // Option type
        );

        if (response == JOptionPane.YES_OPTION) {
            saveData();
            dispose();
        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void saveData() {
        NursingManagementDao.addNursingManagement(
                DbConn.ConnectDb(),
                nm
        );

        for (String diagnosis : selectedDiagnosis) {
            DiagnosisModel dm = new DiagnosisModel(nm.getId(), diagnosis, 0, nm.getPlot());
            NursingManagementDao.addDiagnosis(
                    DbConn.ConnectDb(),
                    dm
            );
        }

        for (String intervention : selectedInterventions) {
            InterventionModel im = new InterventionModel(nm.getId(), intervention, 0, nm.getPlot());
            NursingManagementDao.addIntervention(
                    DbConn.ConnectDb(),
                    im
            );
        }

    }

    // UTILS
    public static String listToString(List<String> list) {
        return String.join(",", list);
    }





    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new jPanelGradient();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        summaryPannel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setMinimumSize(new java.awt.Dimension(727, 600));
        jPanel4.setPreferredSize(new java.awt.Dimension(727, 600));

        jPanel1.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        jLabel5.setText("Nursing Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        summaryPannel.setOpaque(false);

        javax.swing.GroupLayout summaryPannelLayout = new javax.swing.GroupLayout(summaryPannel);
        summaryPannel.setLayout(summaryPannelLayout);
        summaryPannelLayout.setHorizontalGroup(
            summaryPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        summaryPannelLayout.setVerticalGroup(
            summaryPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );

        jPanel2.setOpaque(false);

        saveBtn.setBackground(new java.awt.Color(0, 153, 255));
        saveBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("SAVE");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(saveBtn)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(summaryPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(summaryPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NurseManagementSummary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel summaryPannel;
    // End of variables declaration//GEN-END:variables

   class jPanelGradient extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            Color color1 = new Color(80, 131, 198);
            Color color2 = new Color(130, 206, 234);
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
            g2.setPaint(gp);
            g2.fillRect(0, 0, width, height);
        }
    }
}
