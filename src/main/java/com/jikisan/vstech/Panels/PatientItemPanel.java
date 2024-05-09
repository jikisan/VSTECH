
package com.jikisan.vstech.Panels;

import com.jikisan.vstech.Forms.Dashboard;
import com.jikisan.vstech.Forms.Homepage;
import com.jikisan.vstech.Model.ActivePatient;
import com.jikisan.vstech.Model.PatientModel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import javax.swing.*;

public class PatientItemPanel extends JPanel{

    private JLabel iconLabel;

    public PatientItemPanel(PatientModel patientModel, JFrame parentFrame) {

        String userDir = System.getProperty("user.dir");
        String imagePath = userDir + "\\images\\bed.png"; // Modify as needed

//        String imagePath = userDir + "\\src\\main\\java\\Images\\bed.png"; // Modify as needed
        System.out.println(imagePath);
        ImageIcon icon = new ImageIcon(imagePath);
        int iconLabelSize = 70;

        iconLabel = new JLabel();
        iconLabel.setSize(iconLabelSize, iconLabelSize);
        iconLabel.setMaximumSize(new Dimension(iconLabelSize, iconLabelSize));
        iconLabel.setMinimumSize(new Dimension(iconLabelSize, iconLabelSize));
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setVerticalAlignment(SwingConstants.CENTER);
        iconLabel.setHorizontalTextPosition(JLabel.CENTER);
        iconLabel.setVerticalTextPosition(JLabel.BOTTOM);
        iconLabel.setText(patientModel.getName().toUpperCase(Locale.ROOT));
        iconLabel.setFont(new Font("Arial", Font.BOLD, 14));
        iconLabel.setIconTextGap(20);
        iconLabel.setIcon(icon);

        int panelSize = 200;

        setLayout(new BorderLayout());
        setOpaque(false);
        setMinimumSize(new Dimension(panelSize, panelSize));
        setMaximumSize(new Dimension(panelSize, panelSize));
        setPreferredSize(new Dimension(panelSize, panelSize));
        setSize(new Dimension(panelSize, panelSize));

        // Add icon and label to the panel
        add(iconLabel, BorderLayout.CENTER);
//        add(label, BorderLayout.CENTER);

        // Example mouse listener to handle interactions
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ActivePatient.getInstance().setPatient(patientModel);
                System.out.println(patientModel.getDates());

                new Homepage(patientModel).setVisible(true);
                parentFrame.dispose();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
