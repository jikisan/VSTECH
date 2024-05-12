/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jikisan.vstech.DiagnosisForm;

import com.jikisan.vstech.Forms.Dashboard;
import com.jikisan.vstech.Model.NursingManagement;
import com.jikisan.vstech.Model.PatientModel;
import com.jikisan.vstech.Panels.PatientItemPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class DiagnosisForm extends javax.swing.JFrame {

    private ConditionType condition;
    private JFrame homepageFrame;
    private String[] diagnosisArray;
    private ArrayList<String[]> interventionList;
    private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
    private NursingManagement nm;

    public DiagnosisForm() {
        initComponents();
    }

    public DiagnosisForm(ConditionType condition, JFrame frame, NursingManagement nm) {
        initComponents();
        this.nm = nm;
        this.condition = condition;
        this.homepageFrame = frame;
        fillHeader(condition);
    }

    private void fillHeader(ConditionType condition) {
        conditionHeader.setText(condition.toString());
//        String userDir = System.getProperty("user.dir");
//        String imagePath = userDir + "\\images\\exclamation.png"; // Modify as needed
//        ImageIcon icon = new ImageIcon(imagePath);
//        jLabel1.setIcon(icon);
        jLabel1.setIconTextGap(10);


        switch (condition) {
            case HYPERTHERMIA:
                conditionHeader.setText("HYPERTHERMIA");
                diagnosisArray = DiagnosisAndIntervensions.getHyperthermiaDiagnosis();
                interventionList = DiagnosisAndIntervensions.HYPERTHERMIA_INTERVENTIONS();
                generateDiagnosis(condition);
                break;

            case HYPOTHERMIA:
                conditionHeader.setText("HYPOTHERMIA");
                diagnosisArray = DiagnosisAndIntervensions.getHypothermiaDiagnosis();
                interventionList = DiagnosisAndIntervensions.HYPOTHERMIA_INTERVENTIONS();
                generateDiagnosis(condition);
                break;

            case TACHYCARDIA:
                conditionHeader.setText("TACHYCARDIA");
                diagnosisArray = DiagnosisAndIntervensions.getTachycardiaDiagnosis();
                interventionList = DiagnosisAndIntervensions.TACHYCARDIA_INTERVENTIONS();
                generateDiagnosis(condition);
                break;

            case BRADYCARDIA:
                conditionHeader.setText("BRADYCARDIA");
                diagnosisArray = DiagnosisAndIntervensions.getBradycardiaDiagnosis();
                interventionList = DiagnosisAndIntervensions.BRADYCARDIA_INTERVENTIONS();
                generateDiagnosis(condition);
                break;

            case TACHYPNEA:
                conditionHeader.setText("TACHYPNEA");
                diagnosisArray = DiagnosisAndIntervensions.getTachypneaDiagnosis();
                interventionList = DiagnosisAndIntervensions.TACHYPNEA_INTERVENTIONS();
                generateDiagnosis(condition);
                break;

            case BRADYPNEA:
                conditionHeader.setText("BRADYPNEA");
                diagnosisArray = DiagnosisAndIntervensions.getBradypneaDiagnosis();
                interventionList = DiagnosisAndIntervensions.BRADYPNEA_INTERVENTIONS();
                generateDiagnosis(condition);
                break;

            case HYPERTENSION:
                conditionHeader.setText("HYPERTENSION");
                diagnosisArray = DiagnosisAndIntervensions.getHypertensionDiagnosis();
                interventionList = DiagnosisAndIntervensions.HYPERTENSION_INTERVENTIONS();
                generateDiagnosis(condition);
                break;

            case HYPOTENSION:
                conditionHeader.setText("HYPOTENSION");
                diagnosisArray = DiagnosisAndIntervensions.getHypotensionDiagnosis();
                interventionList = DiagnosisAndIntervensions.HYPOTENSION_INTERVENTIONS();
                generateDiagnosis(condition);
                break;

            case LOW_OXYGEN:
                conditionHeader.setText("LOW OXYGEN");
                break;
        }
    }

    private void generateDiagnosis(ConditionType condition) {

        JPanel diagnosisCards = createDiagnosisCards(condition);
        JScrollPane scrollPane = new JScrollPane(diagnosisCards);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBorder(null);

        panelDiagnosis.removeAll();
        panelDiagnosis.setAutoscrolls(true);
        panelDiagnosis.setLayout(new BoxLayout(panelDiagnosis, BoxLayout.Y_AXIS));
        panelDiagnosis.setOpaque(false);
        panelDiagnosis.add(scrollPane);
        panelDiagnosis.revalidate();
        panelDiagnosis.repaint();

    }

    private JPanel createDiagnosisCards(ConditionType condition) {

        JPanel panel = new JPanel(new GridLayout(0, 1, 0, 0));
        panel.setAutoscrolls(true);
        panel.setOpaque(false);

        for (String diagnosis : diagnosisArray) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setText(diagnosis);
            checkBox.setFont(new Font("Arial", Font.BOLD, 14));
            checkBox.setOpaque(false);
            panel.add(checkBox);
            checkBoxes.add(checkBox);
        }

        return panel;
    }

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        ArrayList<String> newInterventions = new ArrayList<>();

        for (int i = 0; i < checkBoxes.size(); i++) {
            JCheckBox checkBox = checkBoxes.get(i);
            if (checkBox.isSelected()) {

                newInterventions.addAll(Arrays.asList(interventionList.get(i)));
            }
        }//GEN-LAST:event_nextBtnActionPerformed

        System.out.println(newInterventions);
        new InterventionForm(newInterventions, homepageFrame).setVisible(true);
        dispose();
    }





    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new jPanelGradient();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        conditionHeader = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelDiagnosis = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        nextBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(815, 815));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(815, 815));

        jPanel2.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("!! ALERT !!");
        jLabel1.setMinimumSize(new java.awt.Dimension(20, 29));
        jLabel1.setPreferredSize(new java.awt.Dimension(20, 29));

        conditionHeader.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        conditionHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conditionHeader.setText("Loading...");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nursing Diagnosis");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(conditionHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(conditionHeader)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        panelDiagnosis.setAutoscrolls(true);
        panelDiagnosis.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelDiagnosis.setOpaque(false);
        panelDiagnosis.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout panelDiagnosisLayout = new javax.swing.GroupLayout(panelDiagnosis);
        panelDiagnosis.setLayout(panelDiagnosisLayout);
        panelDiagnosisLayout.setHorizontalGroup(
                panelDiagnosisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 559, Short.MAX_VALUE)
        );
        panelDiagnosisLayout.setVerticalGroup(
                panelDiagnosisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 336, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(panelDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel4.setOpaque(false);

        nextBtn.setBackground(new java.awt.Color(0, 153, 255));
        nextBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nextBtn.setForeground(new java.awt.Color(255, 255, 255));
        nextBtn.setText("NEXT");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(367, 367, 367)
                                        .addComponent(nextBtn)
                                        .addContainerGap(367, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 39, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(nextBtn)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(830, 563));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiagnosisForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel conditionHeader;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton nextBtn;
    private javax.swing.JPanel panelDiagnosis;
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
