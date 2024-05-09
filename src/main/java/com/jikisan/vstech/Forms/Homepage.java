package com.jikisan.vstech.Forms;

import com.jikisan.vstech.Model.*;
import com.jikisan.vstech.Panels.TprSheetPanel;
import com.jikisan.vstech.Mapper;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class Homepage extends javax.swing.JFrame {

    private List<TempDataModel> tempData;
    private List<PrDataModel> prData;
    private List<RrDataModel> rrData;
    private List<BpDataModel> bpData;
    private DateListModel dateList;

    private Map<String, Integer> xPointsMap;
    private PatientModel patient;
    private String[] patientDates;
    private String[] xpoints;

    public Homepage() {
        tempData = new ArrayList<TempDataModel>();
        prData = new ArrayList<PrDataModel>();
        rrData = new ArrayList<RrDataModel>();
        bpData = new ArrayList<BpDataModel>();
        new Dashboard().setVisible(true);
        dispose();
//        initComponents();
//        setPlaceholderImg();
//        generateTprSheet();
//
//        tempData = new ArrayList<TempDataModel>();
//        prData = new ArrayList<PrDataModel>();
//        rrData = new ArrayList<RrDataModel>();
//        bpData = new ArrayList<BpDataModel>();


    }

    public Homepage(PatientModel patientModel) {
        tempData = new ArrayList<TempDataModel>();
        prData = new ArrayList<PrDataModel>();
        rrData = new ArrayList<RrDataModel>();
        bpData = new ArrayList<BpDataModel>();

        this.patient = patientModel;
        patientDates = patient.getDates().split(",");
        xPointsMap = Mapper.getXpointsMap(patientDates);
        xpoints = ListToArrayConverter(Mapper.getCombinedDates());

        initComponents();
        setPlaceholderImg();
        generatePatientData(patientModel);
        generateTprSheet();


    }

    private void generatePatientData(PatientModel patient) {

        lblName.setText(patient.getName());
        lblCaseNum.setText(patient.getCaseNumber());
        lblAge.setText(patient.getAge());
        lblDiagnosis.setText(patient.getDiagnosis());
        String userDir = System.getProperty("user.dir");
        String imageName = patient.getPhoto();
        String imagePath = userDir + "\\images\\" + imageName + ".jpg"; // Modify as needed
        ImageIcon icon = new ImageIcon(imagePath);

        lblProfileImg.setIcon(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        lblProfileImg = new javax.swing.JLabel();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblCaseNum = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblDiagnosis = new javax.swing.JLabel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel13 = new javax.swing.JLabel();
        tempTxtField = new javax.swing.JTextField();
        prTextField = new javax.swing.JTextField();
        rrTextField = new javax.swing.JTextField();
        bpTextField = new javax.swing.JTextField();
        o2TxtField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        tprSheetPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(136, 191, 253));
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(196, 203, 228));
        jPanel5.setMinimumSize(new java.awt.Dimension(1500, 1000));
        jPanel5.setPreferredSize(new java.awt.Dimension(1500, 1000));

        jPanel1.setBackground(new java.awt.Color(196, 203, 228));
        jPanel1.setMaximumSize(new java.awt.Dimension(350, 1000));
        jPanel1.setMinimumSize(new java.awt.Dimension(350, 1000));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 1000));

        lblProfileImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfileImg.setMaximumSize(new java.awt.Dimension(150, 150));
        lblProfileImg.setMinimumSize(new java.awt.Dimension(150, 150));
        lblProfileImg.setOpaque(true);
        lblProfileImg.setPreferredSize(new java.awt.Dimension(150, 150));

        jPanel3.setBackground(new java.awt.Color(196, 203, 228));

        lblName.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblName.setText("Loading...");

        lblCaseNum.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblCaseNum.setText("Loading...");

        lblAge.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAge.setText("Loading...");

        lblDiagnosis.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblDiagnosis.setText("Loading...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblCaseNum)
                    .addComponent(lblAge)
                    .addComponent(lblDiagnosis))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblName)
                .addGap(18, 18, 18)
                .addComponent(lblCaseNum)
                .addGap(18, 18, 18)
                .addComponent(lblAge)
                .addGap(18, 18, 18)
                .addComponent(lblDiagnosis)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setText("Values:");

        jPanel2.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setText("T:");

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setText("PR:");

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setText("BP:");

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setText("RR:");

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel13.setText("O2:");

        tempTxtField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tempTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tempTxtFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tempTxtFieldKeyTyped(evt);
            }
        });

        prTextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        prTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prTextFieldKeyTyped(evt);
            }
        });

        rrTextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rrTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rrTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rrTextFieldKeyTyped(evt);
            }
        });

        bpTextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        bpTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bpTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bpTextFieldKeyTyped(evt);
            }
        });

        o2TxtField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        o2TxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                o2TxtFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                o2TxtFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tempTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(rrTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(prTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bpTextField)
                        .addComponent(o2TxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bpTextField, o2TxtField, prTextField, rrTextField, tempTxtField});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tempTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(prTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(rrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(bpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(o2TxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel4.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Case Number:");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Age:");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("Diagnosis");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblProfileImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(43, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblProfileImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 377, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        tprSheetPanel.setMinimumSize(new java.awt.Dimension(1000, 800));
        tprSheetPanel.setPreferredSize(new java.awt.Dimension(1000, 800));

        javax.swing.GroupLayout tprSheetPanelLayout = new javax.swing.GroupLayout(tprSheetPanel);
        tprSheetPanel.setLayout(tprSheetPanelLayout);
        tprSheetPanelLayout.setHorizontalGroup(
            tprSheetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tprSheetPanelLayout.setVerticalGroup(
            tprSheetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 887, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel1.setText("VSTECH");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(868, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tprSheetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tprSheetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents



    private void rrTextFieldKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }

    private void tempTxtFieldKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        boolean isDecimalPoint = (c == '.');
        boolean alreadyHasDecimalPoint = tempTxtField.getText().contains(".");

        if (!Character.isDigit(c) && !(isDecimalPoint && !alreadyHasDecimalPoint)) {
            evt.consume(); // Ignore invalid input
        }

        if (isDecimalPoint && alreadyHasDecimalPoint) {
            evt.consume(); // Disallow more than one decimal point
        }
    }

    private void prTextFieldKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }

    private void bpTextFieldKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }

    private void o2TxtFieldKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }



    private void prTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String pr = prTextField.getText().toString();

            if (pr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a value.");
                return;
            }
            addPR(xpoints[prData.size()], "n/a", prTextField.getText().toString());
        }
    }

    private void rrTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String rr = rrTextField.getText().toString();

            if (rr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a value.");
                return;
            }
            addRR(xpoints[rrData.size()], "n/a", rrTextField.getText().toString());
        }
    }

    private void bpTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String bp = bpTextField.getText().toString();

            if (bp.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a value.");
                return;
            }

        }
    }

    private void o2TxtFieldKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String o2 = o2TxtField.getText().toString();

            if (o2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a value.");
                return;
            }

        }
    }

    private void tempTxtFieldKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String temp = tempTxtField.getText().toString();

            if (temp.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a value.");
                return;
            }

            if (Integer.parseInt(temp) > 43 || Integer.parseInt(temp) < 30) {
                JOptionPane.showMessageDialog(this, "Invalid value.");
                return;
            }

            if (xpoints.length > tempData.size()) {
                addTemp(xpoints[tempData.size()], "n/a", temp);
            }

        }
    }



    private void setPlaceholderImg() {
        // Load the original image
        String currentWorkingDir = System.getProperty("user.dir");
        ImageIcon originalIcon = new ImageIcon(
                currentWorkingDir + "\\src\\main\\java\\Images\\profile_img_placeholder.jpg");

        // Scale the image to fit the JLabel (e.g., 200x200 pixels)
        int newWidth = 200; // Desired width
        int newHeight = 200; // Desired height

        Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        lblProfileImg.setIcon(scaledIcon);
    }

    private void generateTprSheet() {



        String[] temps = {
//                "37", "38.1", "39.2",
//                "38.3", "38.4", "37.8",
//                "38.0", "36.5",
        };
        String[] prs = {
//                "100", "103", "105",
//                "95", "90", "85",
//                "80", "80"
        };
        String[] rrs = {
//                "25", "20", "17",
//                "15", "19", "16",
//                "11", "0"
        };
        String[] bp = {
                // "25", "20", "17",
                // "15", "19", "16",
                // "11", "13"
        };

//        // ADD TEMP DATA
        for (int i = 0; i < temps.length; i++) {
            addTemp(xpoints[i], "n/a", temps[i]);
        }
//
//        // ADD PR DATA
//        for (int i = 0; i < prs.length; i++) {
//            addPR(xpoints[i], "n/a", prs[i]);
//            ;
//        }
//
//        // ADD RR DATA
//        for (int i = 0; i < rrs.length; i++) {
//            addRR(xpoints[i], "n/a", rrs[i]);
//        }
//
//        // ADD BP DATA
//        for (int i = 0; i < bp.length; i++) {
//            bpData.add(new BpDataModel(xpoints[i], "n/a", bp[i]));
//        }


        TprSheetPanel tprSheetCustomPanel = new TprSheetPanel(
                new DataModel(tempData, prData, rrData, bpData),
                xPointsMap,
                patientDates
        );

        // Clear the placeholder and add the custom panel
        tprSheetPanel.removeAll(); // Remove existing content
        tprSheetPanel.setLayout(new BorderLayout()); // Set layout manager, if needed
        tprSheetPanel.add(tprSheetCustomPanel, BorderLayout.CENTER); // Add your custom panel

        // Reapply layout and repaint to ensure changes are reflected
        tprSheetPanel.revalidate();
        tprSheetPanel.repaint();
    }

    private String[] ListToArrayConverter(List<String> combinedDates) {
        String[] stringArray = new String[combinedDates.size()];
        return combinedDates.toArray(stringArray);
    }

    private String[] convertToArray(String dates) {
        String[] tokens = dates.split(",");
        return tokens;
    }

    public void addTemp(String date, String hour, String temp) {
        tempData.add(new TempDataModel(date, hour, temp));
    }

    public void addPR(String date, String hour, String temp) {
        prData.add(new PrDataModel(date, hour, temp));
    }

    public void addRR(String date, String hour, String temp) {

        rrData.add(new RrDataModel(date, hour, temp));
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bpTextField;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblCaseNum;
    private javax.swing.JLabel lblDiagnosis;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblProfileImg;
    private javax.swing.JTextField o2TxtField;
    private javax.swing.JTextField prTextField;
    private javax.swing.JTextField rrTextField;
    private javax.swing.JTextField tempTxtField;
    private javax.swing.JPanel tprSheetPanel;
    // End of variables declaration//GEN-END:variables

}
