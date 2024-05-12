/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jikisan.vstech.DiagnosisForm;

import com.jikisan.vstech.DAO.DbConn;
import com.jikisan.vstech.DAO.NursingManagementDao;
import com.jikisan.vstech.Forms.Homepage;
import com.jikisan.vstech.Forms.LoginPage;
import com.jikisan.vstech.Model.DiagnosisModel;
import com.jikisan.vstech.Model.InterventionModel;
import com.jikisan.vstech.Model.NursingManagement;
import com.jikisan.vstech.Model.PatientModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class NursingManagementForm extends javax.swing.JFrame {

    private ArrayList<String> diagnosis;
    private ArrayList<String> interventions;
    private ArrayList<JCheckBox> diagnosisCheckBoxes;
    private ArrayList<JCheckBox> interventionCheckBoxes;
    private List<DiagnosisModel> diagnosisRecords;
    private List<DiagnosisModel> diagnosisRecordsList;
    private List<InterventionModel> interventionRecords;
    private List<InterventionModel> interventionRecordsList;
    private PatientModel patient;

    public NursingManagementForm() {
        initComponents();
        new Homepage().setVisible(true);
        dispose();
    }

    public NursingManagementForm(PatientModel patient) {
        initComponents();
        this.patient = patient;
        generateData();
    }

    private void generateData() {
        JPanel summaryPanel = createPanel();
        JScrollPane scrollPane = new JScrollPane(summaryPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBorder(null);

        managementPanel.setLayout(new BoxLayout(managementPanel, BoxLayout.Y_AXIS));
        managementPanel.setOpaque(false);
        managementPanel.add(scrollPane);
        managementPanel.revalidate();
        managementPanel.repaint();
    }

    private JPanel createPanel() {
        List<NursingManagement> patientRecords = NursingManagementDao.getNursingManagementDataByPatientId(DbConn.ConnectDb(),patient.getId());
        diagnosisCheckBoxes = new ArrayList<>();
        interventionCheckBoxes = new ArrayList<>();
        diagnosisRecordsList = new ArrayList<>();
        interventionRecordsList = new ArrayList<>();

        JPanel panel = new JPanel(new GridLayout(0, 1, 30, 30));
        panel.setOpaque(false);

        for (int i = 0; i < patientRecords.size(); i++) {

            JPanel recordPanel = new JPanel(new GridLayout(0, 1, 5, 5));
            recordPanel.setOpaque(false);

            JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
            separator.setPreferredSize(new Dimension(200, 1));
            recordPanel.add(separator);

            // Generate date and time
            JLabel title = new JLabel(patientRecords.get(i).getDateTime().toUpperCase());
            title.setFont(new Font("Arial", Font.ITALIC, 22));
            recordPanel.add(title);

            // Generate abnormal finding header
            JLabel abnoHeader = new JLabel("Abnormal Finding");
            abnoHeader.setFont(new Font("Arial", Font.BOLD, 18));
            recordPanel.add(abnoHeader);

            // Generate abnormal finding
            JLabel abnormalFinding = new JLabel(patientRecords.get(i).getAbnormalFinding().toUpperCase());
            abnormalFinding.setFont(new Font("Arial", Font.PLAIN, 15));
            recordPanel.add(abnormalFinding);

            // Generate diagnosis header
            JLabel diagHeader = new JLabel("Nursing Diagnosis");
            diagHeader.setFont(new Font("Arial", Font.BOLD, 18));
            recordPanel.add(diagHeader);

            // Generate diagnosis list
            diagnosisRecords = NursingManagementDao.getDiagnosisByNmId(
                    DbConn.ConnectDb(),
                    patientRecords.get(i).getId()
            );

            for ( DiagnosisModel record : diagnosisRecords) {
                JCheckBox checkBox = new JCheckBox(record.getDiagnosis());
                checkBox.setFont(new Font("Arial", Font.PLAIN, 15));
                checkBox.setOpaque(false);

                if (record.getIsDiagnosisChecked() == 1) {
                    checkBox.setSelected(true);
                }
                recordPanel.add(checkBox);
                diagnosisRecordsList.add(record);
                diagnosisCheckBoxes.add(checkBox);
            }

            // Generate intervention header
            JLabel interHeader = new JLabel("Nursing Intervention");
            interHeader.setFont(new Font("Arial", Font.BOLD, 18));
            recordPanel.add(interHeader);


            // Generate intervention list
            interventionRecords = NursingManagementDao.getInterventionByNmId(
                    DbConn.ConnectDb(),
                    patientRecords.get(i).getId()
            );

            for ( InterventionModel record : interventionRecords) {
                JCheckBox checkBox = new JCheckBox(record.getIntervention());
                checkBox.setFont(new Font("Arial", Font.PLAIN, 15));
                checkBox.setOpaque(false);

                if (record.getIsInterventionChecked() == 1) {
                    checkBox.setSelected(true);
                }
                recordPanel.add(checkBox);
                interventionRecordsList.add(record);
                interventionCheckBoxes.add(checkBox);
            }



            panel.add(recordPanel);
        }

        return panel;
    }

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        for (int i = 0; i < diagnosisCheckBoxes.size(); i++) {
            JCheckBox checkBox = diagnosisCheckBoxes.get(i);
            DiagnosisModel record = diagnosisRecordsList.get(i);
            int isChecked = checkBox.isSelected() ? 1 : 0;
            record.setIsDiagnosisChecked(isChecked);
            NursingManagementDao.updateDiagnosisChecked(
                    DbConn.ConnectDb(),
                    record.getNursingManagementId(),
                    isChecked == 1
            );
        }

        // Update intervention checkboxes
        for (int i = 0; i < interventionCheckBoxes.size(); i++) {
            JCheckBox checkBox = interventionCheckBoxes.get(i);
            InterventionModel record = interventionRecordsList.get(i);
            int isChecked = checkBox.isSelected() ? 1 : 0;
            record.setIsInterventionChecked(isChecked);
            NursingManagementDao.updateInterventionChecked(
                    DbConn.ConnectDb(),
                    record.getNursingManagementId(),
                    isChecked == 1
            );
        }

        dispose();
    }//GEN-LAST:event_saveBtnActionPerformed

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new jPanelGradient();
        jLabel5 = new javax.swing.JLabel();
        managementPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(800, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 700));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nurse Management");

        managementPanel.setOpaque(false);

        javax.swing.GroupLayout managementPanelLayout = new javax.swing.GroupLayout(managementPanel);
        managementPanel.setLayout(managementPanelLayout);
        managementPanelLayout.setHorizontalGroup(
            managementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        managementPanelLayout.setVerticalGroup(
            managementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );

        jPanel3.setOpaque(false);

        saveBtn.setBackground(new java.awt.Color(0, 153, 255));
        saveBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("SAVE");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(managementPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(managementPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NursingManagementForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel managementPanel;
    private javax.swing.JButton saveBtn;
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
