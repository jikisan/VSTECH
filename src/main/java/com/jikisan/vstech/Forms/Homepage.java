package com.jikisan.vstech.Forms;

import com.jikisan.vstech.DAO.DbConn;
import com.jikisan.vstech.DAO.PatientDao;
import com.jikisan.vstech.DiagnosisForm.ConditionType;
import com.jikisan.vstech.DiagnosisForm.DiagnosisForm;
import com.jikisan.vstech.Model.*;
import com.jikisan.vstech.Panels.TprSheetPanel;
import com.jikisan.vstech.Mapper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Homepage extends JFrame {

    private List<TempDataModel> tempData;
    private List<PrDataModel> prData;
    private List<RrDataModel> rrData;
    private List<BpDataModel> bpData;

    private Map<String, Integer> xPointsMap;
    private Map<String, Integer> bpXpointsMap;
    private PatientModel patient;
    private String[] patientDates;
    private String[] xpoints;
    private String[] bpXpoints;

    public Homepage() {
        tempData = new ArrayList<TempDataModel>();
        prData = new ArrayList<PrDataModel>();
        rrData = new ArrayList<RrDataModel>();
        bpData = new ArrayList<BpDataModel>();
        new Dashboard().setVisible(true);
        dispose();
    }

    public Homepage(PatientModel patientModel) {
        tempData = new ArrayList<TempDataModel>();
        prData = new ArrayList<PrDataModel>();
        rrData = new ArrayList<RrDataModel>();
        bpData = new ArrayList<BpDataModel>();

        this.patient = patientModel;
        patientDates = patient.getDates().split(",");

        xPointsMap = Mapper.getXpointsMap(patientDates);
        bpXpointsMap = Mapper.getBpXpointsMap(patientDates);

        xpoints = ListToArrayConverter(Mapper.getCombinedDates());
        bpXpoints = ListToArrayConverter(Mapper.getBpCombinedDates());

        initComponents();
        setPlaceholderImg();
        generatePatientData(patientModel);
        generateTprSheet(patientModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new jPanelGradient();
        JPanel jPanel1 = new JPanel();
        lblProfileImg = new JLabel();
        JPanel jPanel3 = new JPanel();
        lblName = new JLabel();
        lblCaseNum = new JLabel();
        lblAge = new JLabel();
        lblDiagnosis = new JLabel();
        JLabel jLabel8 = new JLabel();
        jPanel2 = new JPanel();
        JLabel jLabel9 = new JLabel();
        JLabel jLabel10 = new JLabel();
        JLabel jLabel11 = new JLabel();
        JLabel jLabel12 = new JLabel();
        JLabel jLabel13 = new JLabel();
        tempTxtField = new JTextField();
        prTextField = new JTextField();
        rrTextField = new JTextField();
        bpTextField = new JTextField();
        o2TxtField = new JTextField();
        bpHoursComboBox = new JComboBox<>();
        jPanel4 = new JPanel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel6 = new JLabel();
        backBtn = new JLabel();
        tprSheetPanel = new JPanel();
        jPanel6 = new JPanel();
        JLabel jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new Color(136, 191, 253));
        setResizable(false);

        jPanel5.setBackground(new Color(196, 203, 228));
        jPanel5.setMinimumSize(new Dimension(1500, 1000));
        jPanel5.setPreferredSize(new Dimension(1500, 1000));

        jPanel1.setBackground(new Color(196, 203, 228));
        jPanel1.setMaximumSize(new Dimension(350, 1000));
        jPanel1.setMinimumSize(new Dimension(350, 1000));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new Dimension(350, 1000));

        lblProfileImg.setHorizontalAlignment(SwingConstants.CENTER);
        lblProfileImg.setMaximumSize(new Dimension(150, 150));
        lblProfileImg.setMinimumSize(new Dimension(150, 150));
        lblProfileImg.setOpaque(true);
        lblProfileImg.setPreferredSize(new Dimension(150, 150));

        jPanel3.setBackground(new Color(196, 203, 228));
        jPanel3.setOpaque(false);

        lblName.setFont(new Font("Roboto", 1, 18)); // NOI18N
        lblName.setText("Loading...");

        lblCaseNum.setFont(new Font("Roboto", 1, 18)); // NOI18N
        lblCaseNum.setText("Loading...");

        lblAge.setFont(new Font("Roboto", 1, 18)); // NOI18N
        lblAge.setText("Loading...");

        lblDiagnosis.setFont(new Font("Roboto", 1, 18)); // NOI18N
        lblDiagnosis.setText("Loading...");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblName)
                                        .addComponent(lblCaseNum)
                                        .addComponent(lblAge)
                                        .addComponent(lblDiagnosis))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblName)
                                .addGap(18, 18, 18)
                                .addComponent(lblCaseNum)
                                .addGap(18, 18, 18)
                                .addComponent(lblAge)
                                .addGap(18, 18, 18)
                                .addComponent(lblDiagnosis)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setText("Values:");

        jPanel2.setOpaque(false);

        jLabel9.setFont(new Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setText("T:");

        jLabel10.setFont(new Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setText("PR:");

        jLabel11.setFont(new Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setText("BP:");

        jLabel12.setFont(new Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setText("RR:");

        jLabel13.setFont(new Font("Roboto", 0, 12)); // NOI18N
        jLabel13.setText("O2:");

        tempTxtField.setFont(new Font("Roboto", 0, 12)); // NOI18N
        tempTxtField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                tempTxtFieldKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                tempTxtFieldKeyTyped(evt);
            }
        });

        prTextField.setFont(new Font("Roboto", 0, 12)); // NOI18N
        prTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                prTextFieldKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                prTextFieldKeyTyped(evt);
            }
        });

        rrTextField.setFont(new Font("Roboto", 0, 12)); // NOI18N
        rrTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                rrTextFieldKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                rrTextFieldKeyTyped(evt);
            }
        });

        bpTextField.setFont(new Font("Roboto", 0, 12)); // NOI18N
        bpTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                bpTextFieldKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                bpTextFieldKeyTyped(evt);
            }
        });

        o2TxtField.setFont(new Font("Roboto", 0, 12)); // NOI18N
        o2TxtField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                o2TxtFieldKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                o2TxtFieldKeyTyped(evt);
            }
        });

        bpHoursComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"6-2", "2-10", "10-6", " "}));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(21, 21, 21)
                                                .addComponent(o2TxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel10))
                                                .addGap(21, 21, 21)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(tempTxtField, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(rrTextField)
                                                        .addComponent(prTextField)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(21, 21, 21)
                                                .addComponent(bpTextField)
                                                .addGap(18, 18, 18)
                                                .addComponent(bpHoursComboBox, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                                .addGap(57, 57, 57))
        );

        jPanel2Layout.linkSize(SwingConstants.HORIZONTAL, new Component[]{bpTextField, o2TxtField, prTextField, rrTextField, tempTxtField});

        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(tempTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(prTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(rrTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(o2TxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(bpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bpHoursComboBox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(SwingConstants.VERTICAL, new Component[]{bpHoursComboBox, bpTextField});

        jPanel4.setOpaque(false);

        jLabel2.setFont(new Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Case Number:");

        jLabel4.setFont(new Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Age:");

        jLabel6.setFont(new Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("Diagnosis");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addContainerGap())
        );

        backBtn.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        backBtn.setLabelFor(backBtn);
        backBtn.setText("Back");
        backBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(lblProfileImg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(backBtn)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backBtn)
                                .addGap(9, 9, 9)
                                .addComponent(lblProfileImg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 352, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
        );

        tprSheetPanel.setMinimumSize(new Dimension(1000, 800));
        tprSheetPanel.setOpaque(false);
        tprSheetPanel.setPreferredSize(new Dimension(1000, 800));

        GroupLayout tprSheetPanelLayout = new GroupLayout(tprSheetPanel);
        tprSheetPanel.setLayout(tprSheetPanelLayout);
        tprSheetPanelLayout.setHorizontalGroup(
                tprSheetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        tprSheetPanelLayout.setVerticalGroup(
                tprSheetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 887, Short.MAX_VALUE)
        );

        jPanel6.setOpaque(false);

        jLabel1.setFont(new Font("Segoe UI", 3, 48)); // NOI18N
        jLabel1.setText("VSTECH");

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap(868, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(tprSheetPanel, GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
                                                .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tprSheetPanel, GroupLayout.PREFERRED_SIZE, 887, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseClicked(MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        new Dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_backBtnMouseClicked

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

    private void generateTprSheet(PatientModel patientModel) {

        for (String temp : stringToList(patientModel.getTempData())) {
            addTemp(xpoints[tempData.size()], "n/a", temp);
        }

        for (String pr : stringToList(patient.getPrData())) {
            addPR(xpoints[prData.size()], "n/a", pr);
        }

        for (String rr : stringToList(patient.getRrData())) {
            addRR(xpoints[rrData.size()], "n/a", rr);
        }

        for (String bp : stringToList(patient.getBpData())) {

            if (bp.isEmpty()) {
                return;
            }
            System.out.println(bp);

            String[] partsSplit = bp.split("\\.");
            System.out.println(partsSplit.length);

            if (partsSplit.length < 3) {
                continue;
            }

            String date = partsSplit[0];
            String hour = partsSplit[1];
            String bpSplit = partsSplit[2];

            addBP(date, hour, bpSplit);
        }

        TprSheetPanel tprSheetCustomPanel = new TprSheetPanel(
                new DataModel(tempData, prData, rrData, bpData),
                xPointsMap,
                bpXpointsMap,
                patientDates
        );

        tprSheetPanel.removeAll();
        tprSheetPanel.setLayout(new BorderLayout());
        tprSheetPanel.add(tprSheetCustomPanel, BorderLayout.CENTER);
        tprSheetPanel.revalidate();
        tprSheetPanel.repaint();
    }


    //KEYTYPED
    private void tempTxtFieldKeyTyped(KeyEvent evt) {
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

    private void rrTextFieldKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }

    private void prTextFieldKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }

    private void o2TxtFieldKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }

    private void bpTextFieldKeyTyped(KeyEvent evt) {

    }


    //KEYPRESSED
    private void tempTxtFieldKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String temp = tempTxtField.getText().toString();

            if (temp.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a value.");
                return;
            }

            if (Float.parseFloat(temp) > 43 || Float.parseFloat(temp) < 30) {
                JOptionPane.showMessageDialog(this, "Invalid input.");
                return;
            }

            if (xpoints.length > tempData.size()) {
                addTemp(xpoints[tempData.size()], "n/a", limitToFirstFour(temp));
                PatientDao.updatePatientData(
                        DbConn.ConnectDb(),
                        patient.getId(),
                        tempDataToString(tempData),
                        "tempData"
                );
            }

            if (Float.parseFloat(temp) < 36.5) {
//                JOptionPane.showMessageDialog(this, "HYPOTHERMIA");
                new DiagnosisForm(ConditionType.HYPOTHERMIA, this).setVisible(true);

            }

            if (Float.parseFloat(temp) > 37.5) {
//                JOptionPane.showMessageDialog(this, "HYPERTHERMIA");
                new DiagnosisForm(ConditionType.HYPERTHERMIA, this).setVisible(true);

            }

        }
    }

    private void prTextFieldKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String pr = prTextField.getText().toString();

            if (pr.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please enter a value.");
                return;
            }

            if (Float.parseFloat(pr) > 200 || Float.parseFloat(pr) < 1) {
//                JOptionPane.showMessageDialog(this, "Invalid input.");
                return;
            }

            if (xpoints.length > prData.size()) {
                addPR(xpoints[prData.size()], "n/a", prTextField.getText().toString());
                PatientDao.updatePatientData(
                        DbConn.ConnectDb(),
                        patient.getId(),
                        prDataToString(prData),
                        "prData"
                );
                PatientDao.updatePatientData(
                        DbConn.ConnectDb(),
                        patient.getId(),
                        prDataToString(prData),
                        "prData"
                );
            }

            if (Float.parseFloat(pr) < 60) {
//                JOptionPane.showMessageDialog(this, "BRADYCARDIA ");
                new DiagnosisForm(ConditionType.BRADYCARDIA, this).setVisible(true);
            }

            if (Float.parseFloat(pr) > 101) {
//                JOptionPane.showMessageDialog(this, "TACHYCARDIA");
                new DiagnosisForm(ConditionType.TACHYCARDIA, this).setVisible(true);
            }

        }
    }

    private void rrTextFieldKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String rr = rrTextField.getText().toString();

            if (rr.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please enter a value.");

                return;
            }

            if (Float.parseFloat(rr) > 200 || Float.parseFloat(rr) < 1) {
//                JOptionPane.showMessageDialog(this, "Invalid input.");

                return;
            }

            if (xpoints.length > rrData.size()) {
                addRR(xpoints[rrData.size()], "n/a", rrTextField.getText().toString());
                PatientDao.updatePatientData(
                        DbConn.ConnectDb(),
                        patient.getId(),
                        rrDataToString(rrData),
                        "rrData"
                );
            }

            if (Float.parseFloat(rr) < 12) {
//                JOptionPane.showMessageDialog(this, "BRADYPNEA ");
                new DiagnosisForm(ConditionType.BRADYPNEA, this).setVisible(true);

            }

            if (Float.parseFloat(rr) > 20) {
//                JOptionPane.showMessageDialog(this, "TACHYPNEA");
                new DiagnosisForm(ConditionType.TACHYPNEA, this).setVisible(true);

            }

        }
    }

    private void o2TxtFieldKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String o2 = o2TxtField.getText().toString();

            if (o2.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please enter a value.");

                return;
            }

            if (Float.parseFloat(o2) > 100 || Float.parseFloat(o2) < 0) {
//                JOptionPane.showMessageDialog(this, "Invalid input.");

                return;
            }


            if (Float.parseFloat(o2) < 95) {
//                JOptionPane.showMessageDialog(this, "LOW OXYGEN");
                new DiagnosisForm(ConditionType.LOW_OXYGEN, this).setVisible(true);

            }
        }
    }

    private void bpTextFieldKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String bp = bpTextField.getText().toString();
            String bpHours = bpHoursComboBox.getSelectedItem().toString();
            if (bp.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please enter a value.");
                return;
            }

            int count = countOccurrences(bpData, bpHours);

            // Validate blood pressure format (e.g., "120/80")
            String[] parts = bp.split("/");
            if (parts.length != 2) {
                JOptionPane.showMessageDialog(this, "Invalid BP format. Use 'systolic/diastolic' (e.g., 120/80).");
                return;
            }

            int systolic, diastolic;
            try {
                systolic = Integer.parseInt(parts[0].trim());
                diastolic = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid numeric value. Please enter integers for systolic and diastolic values.");
                return;
            }

            // Validate blood pressure range
            if (systolic > 120 && diastolic > 80) {
                new DiagnosisForm(ConditionType.HYPERTENSION, this).setVisible(true);

            } else if (systolic < 90 && diastolic < 60) {
                new DiagnosisForm(ConditionType.HYPOTENSION, this).setVisible(true);
            }


            if (count < 10) {
                String bpDate = bpXpoints[count];
                addBP(bpDate, bpHours, bp);
                PatientDao.updatePatientData(
                        DbConn.ConnectDb(),
                        patient.getId(),
                        bpDataToString(bpData),
                        "bpData"
                );
            }

        }
    }


    //ADD DATA
    public void addTemp(String date, String hour, String temp) {
        tempData.add(new TempDataModel(date, hour, temp));
    }

    public void addPR(String date, String hour, String pr) {
        prData.add(new PrDataModel(date, hour, pr));
    }

    public void addRR(String date, String hour, String rr) {
        rrData.add(new RrDataModel(date, hour, rr));
    }

    public void addBP(String date, String hour, String bp) {
        bpData.add(new BpDataModel(date, hour, bp));
    }


    //UTILS
    public String limitToFirstFour(String input) {
        // Find the index of the decimal point, if it exists
        int decimalIndex = input.indexOf(".");

        // If there's no decimal, return the first four characters
        if (decimalIndex == -1) {
            return input.substring(0, Math.min(4, input.length()));
        }

        // Determine the total length, including the integer and fractional parts
        int maxAllowed = decimalIndex + 2; // One character after the decimal point

        // Get the allowed substring (first part of the integer, one part of the decimal)
        String limitedString = input.substring(0, Math.min(maxAllowed, input.length()));

        return limitedString;
    }

    private String[] ListToArrayConverter(List<String> combinedDates) {
        String[] stringArray = new String[combinedDates.size()];
        return combinedDates.toArray(stringArray);
    }

    private String[] convertToArray(String dates) {
        String[] tokens = dates.split(",");
        return tokens;
    }

    public static String listToString(List<String> list) {
        return String.join(",", list);
    }

    public String tempDataToString(List<TempDataModel> list) {
        StringJoiner joiner = new StringJoiner(",");

        for (TempDataModel item : list) {
            joiner.add(item.getTemp());
        }

        return joiner.toString();
    }

    private String prDataToString(List<PrDataModel> list) {
        StringJoiner joiner = new StringJoiner(",");

        for (PrDataModel item : list) {
            joiner.add(item.getPR());
        }

        return joiner.toString();
    }

    private String rrDataToString(List<RrDataModel> list) {
        StringJoiner joiner = new StringJoiner(",");

        for (RrDataModel item : list) {
            joiner.add(item.getRR());
        }

        return joiner.toString();
    }

    private String bpDataToString(List<BpDataModel> list) {
        StringJoiner joiner = new StringJoiner(",");

        for (BpDataModel item : list) {
            String date = item.getDate();
            String hour = item.getHour();
            String bp = item.getBp();
            String bpData = date + "." + hour + "." + bp;
            joiner.add(bpData);
        }

        return joiner.toString();
    }

    public static List<String> stringToList(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.asList(str.split(","));
    }

    private int countOccurrences(List<BpDataModel> list, String target) {
        int count = 0;

        for (BpDataModel item : list) {

            if (item.getHour().equals(target)) {
                count++;
            }
        }
        return count;
    }


    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel backBtn;
    private JComboBox<String> bpHoursComboBox;
    private JTextField bpTextField;
    private JPanel jPanel2;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JLabel lblAge;
    private JLabel lblCaseNum;
    private JLabel lblDiagnosis;
    private JLabel lblName;
    private JLabel lblProfileImg;
    private JTextField o2TxtField;
    private JTextField prTextField;
    private JTextField rrTextField;
    private JTextField tempTxtField;
    private JPanel tprSheetPanel;
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
